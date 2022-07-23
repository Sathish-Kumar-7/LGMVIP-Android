package com.example.lgm_covidtrackerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lgm_covidtrackerapp.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var binding:FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTitleBinding.inflate(layoutInflater)
        binding.fetchButton.setOnClickListener {
            findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToStateSelectionFragment())
        }
        return binding.root
    }
}