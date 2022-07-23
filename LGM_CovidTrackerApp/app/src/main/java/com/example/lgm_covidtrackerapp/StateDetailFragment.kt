package com.example.lgm_covidtrackerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.lgm_covidtrackerapp.databinding.FragmentStateDetailBinding
import com.example.lgm_covidtrackerapp.model.CovidViewModel
import com.example.lgm_covidtrackerapp.recyclerview.DistrictStateRecyclerViewAdapter

class StateDetailFragment : Fragment() {
    private lateinit var binding: FragmentStateDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStateDetailBinding.inflate(layoutInflater)
        val state = CovidViewModel.getStateData(arguments?.getString("stateName")?:"")
        binding.stateTextView.text = state?.name
        binding.confirmedTV.text =  getString(R.string.confirmed,(state?.confirmed?:0).toString())
        binding.activeTV.text = getString(R.string.active,(state?.active?:0).toString())
        binding.migrateTV.text = getString(R.string.migrate,(state?.migrate?:0).toString())
        binding.deceasedTV.text = getString(R.string.deceased,(state?.deceased?:0).toString())
        binding.recoveredTV.text = getString(R.string.recovered,(state?.recovered?:0).toString())
        binding.deltaConfirmedTV.text = getString(R.string.confirmed,(state?.delta?.confirmed?:0).toString())
        binding.deltaDeceasedTV.text = getString(R.string.deceased,(state?.delta?.deceased?:0).toString())
        binding.deltaRecoveredTV.text = getString(R.string.recovered,(state?.delta?.recovered?:0).toString())
        binding.districtRecyclerView.adapter = DistrictStateRecyclerViewAdapter(requireContext(),state!!)
        binding.districtRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        return binding.root
    }

}