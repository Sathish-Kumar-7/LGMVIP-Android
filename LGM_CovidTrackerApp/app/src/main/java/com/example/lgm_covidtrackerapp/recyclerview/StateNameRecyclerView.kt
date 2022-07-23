package com.example.lgm_covidtrackerapp.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lgm_covidtrackerapp.StateSelectionFragment
import com.example.lgm_covidtrackerapp.StateSelectionFragmentDirections
import com.example.lgm_covidtrackerapp.databinding.FragmentStateSelectionBinding
import com.example.lgm_covidtrackerapp.databinding.StateNameLayoutBinding
import com.example.lgm_covidtrackerapp.model.CovidViewModel

class StateNameRecyclerViewAdapeter(val context:Context) :
    RecyclerView.Adapter<StateNameRecyclerViewAdapeter.StateNameRecyclerViewHolder>(){
    inner class StateNameRecyclerViewHolder(val binding: StateNameLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    var stateNameList = CovidViewModel.listOfStateNames
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateNameRecyclerViewHolder {
        val binding = StateNameLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StateNameRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return stateNameList.value?.size?:0
    }

    override fun onBindViewHolder(holder: StateNameRecyclerViewHolder, position: Int) {
        Log.d("Test","Its Working Buddy")
        val stateName = stateNameList.value?.get(position) ?: ""
        holder.binding.stateNameTV.text = stateName
        holder.binding.stateNameTV.setOnClickListener {
            CovidViewModel.choosenState.value = stateName
//            StateSelectionFragment().requireParentFragment().findNavController().navigate(
//                StateSelectionFragmentDirections.actionStateSelectionFragmentToStateDetailFragment()
//            )
            Navigation.findNavController(it).navigate(
                StateSelectionFragmentDirections.actionStateSelectionFragmentToStateDetailFragment(stateName)
            )
        }
    }
}