package com.example.demoapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.demoapp.R
import com.example.demoapp.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    private val viewModel: ProfileViewModel by viewModels()

    private lateinit var tokenManger: TokenManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = MainFragmentBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        tokenManger = TokenManager(requireContext())

        binding.logInButton.setOnClickListener {
            viewModel.userLogInAuthetication()
            findNavController().navigate(MainFragmentDirections.actionNavigationMainToNavigationProfile())
        }

        viewModel.logInData.observe(
            viewLifecycleOwner,
            {
                tokenManger.saveToken(it.token)
                binding.logInTextView.text = it.token
            }
        )
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
