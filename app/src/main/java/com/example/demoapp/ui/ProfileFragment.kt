package com.example.demoapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.demoapp.R
import com.example.demoapp.databinding.ProfileFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.profile_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ProfileFragmentBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
    }
}