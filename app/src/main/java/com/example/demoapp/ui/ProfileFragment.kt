package com.example.demoapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.demoapp.R
import com.example.demoapp.databinding.ProfileFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.profile_fragment) {

    private val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ProfileFragmentBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.getUserProfile()

        viewModel.userData.observe(
            viewLifecycleOwner,
            {
                binding.nameTextView.text = it.user_name
                binding.birthdayTextView.text = it.bir
                binding.aboutTextView.text = it.about
            }
        )
    }
}
