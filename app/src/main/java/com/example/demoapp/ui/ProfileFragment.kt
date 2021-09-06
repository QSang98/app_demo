package com.example.demoapp.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.demoapp.BuildConfig
import com.example.demoapp.Constant
import com.example.demoapp.R
import com.example.demoapp.databinding.ProfileFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okio.BufferedSink
import okio.source
import java.io.FileDescriptor
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.jvm.Throws

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.profile_fragment) {

    private val REQUEST_CODE = 100

    private var imageTime: Long? = null

    private lateinit var requestBody: RequestBody

    private val viewModel: ProfileViewModel by viewModels()

    private val act by lazy {
        requireActivity() as AppCompatActivity
    }

    private lateinit var tokenManager: TokenManager

    private lateinit var activityResultLaunch: ActivityResultLauncher<Intent>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ProfileFragmentBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        act.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        setHasOptionsMenu(true)

        tokenManager = TokenManager(requireContext())

        val token = tokenManager.fetchToken() as String

        viewModel.getUserProfile()

        viewModel.userData.observe(
            viewLifecycleOwner,
            {
                binding.nameTextView.text = it.userName
                binding.birthdayTextView.text = it.bir
                binding.aboutTextView.text = it.about
                Glide.with(requireContext())
                    .load("http://static-two.ntq.solutions/api=load_img&img_id=${it.avaId}&img_kind=1")
                    .error(R.drawable.ic_add_photo_foreground)
                    .into(binding.photoImageView)
            }
        )

        binding.photoImageView.setOnClickListener {
            onClickRequestPermission()
        }

        activityResultLaunch = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {
                if (it.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = it.data
                    if (data == null) {
                        return@ActivityResultCallback
                    }

                    val uri: Uri? = data.data

                    imageTime = System.currentTimeMillis()

                    try {
                        uri?.let {
                            val p: ParcelFileDescriptor? = act.getContentResolver().openFileDescriptor(it, "r")
                            if (p != null) {
                                val fileDescriptor: FileDescriptor = p.getFileDescriptor()
                                val image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
                                binding.photoImageView.setImageBitmap(image)
                                p.close()
                            }

                            val sum = getMD5EncryptedString(requireContext(), it)

                            var imageSize: Long? = null

                            act.contentResolver.query(it, arrayOf(MediaStore.Images.Media.SIZE), null, null, null)
                                ?.use {
                                    while (it.moveToNext()) {
                                        imageSize = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE))
                                    }
                                }

                            requestBody = it.asRequestBody(requireContext()) as RequestBody

                            viewModel.updateUserProfile(
                                Constant.API_UPLOAD,
                                token,
                                sum,
                                imageSize as Long,
                                imageTime as Long,
                                requestBody
                            )
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.update -> {
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun onClickRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            openGallery()
            return
        }

        if (act.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            openGallery()
        } else {
            val permission: Array<String> = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
            act.requestPermissions(permission, REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery()
            }
        }
    }

    private fun openGallery() {
        val intent = Intent()
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        activityResultLaunch.launch(Intent.createChooser(intent, "Select Picture"))
    }

//    private fun md5(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(
//        str.toByteArray(
//            Charsets.UTF_8
//        )
//    )
//    private fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }

    fun getMD5EncryptedString(context: Context, uri: Uri): String {
        var inputStream: InputStream? = null
        val buffer = ByteArray(1024)
        try {
            val mdEnc = MessageDigest.getInstance("MD5")
            mdEnc.reset()
            inputStream = context.contentResolver.openInputStream(uri)
            inputStream?.let {
                var read: Int?
                while (true) {
                    read = it.read(buffer)
                    if (read < 0) break
                    mdEnc.update(buffer, 0, read)
                }
                val md5sum = mdEnc.digest()
                val builder = StringBuilder()
                val HEX = 16
                val md5Size = md5sum.size
                for (i in 0 until md5Size) {
                    builder.append(
                        ((md5sum[i].toInt() and 0xff) + 0x100).toString(HEX).substring(1)
                    )
                }
                return builder.toString()
            }
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return ""
    }

    @Throws(IOException::class)
    fun Uri.asRequestBody(context: Context): RequestBody? {

        val inputFileStream = try {
            context.contentResolver.openInputStream(this)
        } catch (e: Exception) {
            null
        }

        val contentType = try {
            context.contentResolver.getType(this)?.toMediaTypeOrNull()
        } catch (e: Exception) {
            null
        }

        return if (inputFileStream == null || contentType == null) null
        else {
            object : RequestBody() {

                override fun contentType(): MediaType {
                    return contentType
                }

                override fun writeTo(sink: BufferedSink) {
                    inputFileStream.source().use { sink.writeAll(it) }
                }
            }
        }
    }
}
