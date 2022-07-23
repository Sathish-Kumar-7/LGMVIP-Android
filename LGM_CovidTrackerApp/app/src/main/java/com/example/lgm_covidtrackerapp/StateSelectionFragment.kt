package com.example.lgm_covidtrackerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lgm_covidtrackerapp.databinding.FragmentStateSelectionBinding
import com.example.lgm_covidtrackerapp.model.CovidViewModel
import com.example.lgm_covidtrackerapp.recyclerview.StateNameRecyclerViewAdapeter


class StateSelectionFragment : Fragment() {
    private lateinit var binding: FragmentStateSelectionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStateSelectionBinding.inflate(layoutInflater)
        binding.searchEditText.queryHint = "Search State"
        CovidViewModel.list.observe(
            requireActivity(), Observer {
                binding.recyclerView.invalidate()
            }
        )
        binding.apply {
            confirmedTV.text = getString(R.string.confirmed,CovidViewModel.list.value?.sumBy {
                it.confirmed.toInt()
            }.toString())
            recoveredTV.text = getString(R.string.recovered,CovidViewModel.list.value?.sumBy {
                it.recovered.toInt()
            }.toString())
            migrateTV.text = getString(R.string.migrate,CovidViewModel.list.value?.sumBy {
                it.migrate.toInt()
            }.toString())
            deceasedTV.text = getString(R.string.deceased,CovidViewModel.list.value?.sumBy {
                it.deceased.toInt()
            }.toString())
            activeTV.text = getString(R.string.active,CovidViewModel.list.value?.sumBy {
                it.active.toInt()
            }.toString())
            deltaConfirmedTV.text = getString(R.string.confirmed,CovidViewModel.list.value?.sumBy {
                it.delta.confirmed.toInt()
            }.toString())
            deltaRecoveredTV.text = getString(R.string.recovered,CovidViewModel.list.value?.sumBy {
                it.delta.recovered.toInt()
            }.toString())
            deltaDeceasedTV.text = getString(R.string.deceased,CovidViewModel.list.value?.sumBy {
                it.delta.deceased.toInt()
            }.toString())
        }
        binding.recyclerView.adapter = StateNameRecyclerViewAdapeter(requireContext())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        return binding.root
    }
}