package com.example.lgm_covidtrackerapp.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lgm_covidtrackerapp.R
import com.example.lgm_covidtrackerapp.databinding.DistrictDataLayoutBinding
import com.example.lgm_covidtrackerapp.model.State

class DistrictStateRecyclerViewAdapter(val context: Context, val state:State): RecyclerView.Adapter<DistrictStateRecyclerViewAdapter.DistrictStateRecyclerViewVH>() {
    inner class DistrictStateRecyclerViewVH(val binding:DistrictDataLayoutBinding): RecyclerView.ViewHolder(binding.root)
    val districts = state.districts
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistrictStateRecyclerViewVH {
        val binding =DistrictDataLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DistrictStateRecyclerViewVH(binding)
    }

    override fun getItemCount(): Int {
        return districts.size
    }

    override fun onBindViewHolder(holder: DistrictStateRecyclerViewVH, position: Int) {
        val district = districts[position]
        holder.binding.apply {
            districtextView.text = district.name
            confirmedTV.text = context.getString(
                R.string.confirmed, district.confirmed.toString())
            deceasedTV.text = context.getString(
                R.string.deceased, district.deceased.toString())
            recoveredTV.text = context.getString(
                R.string.recovered, district.recovered.toString())
            migrateTV.text = context.getString(
                R.string.migrate, district.migrate.toString())
            activeTV.text = context.getString(
                R.string.active, district.active.toString())
            deltaConfirmedTV.text = context.getString(
                R.string.confirmed, (district.delta?.confirmed?:0).toString())
            deltaDeceasedTV.text = context.getString(
                R.string.deceased, district.delta?.deceased?:0.toString())
            deltaRecoveredTV.text = context.getString(
                R.string.recovered,district.delta?.recovered?:0.toString())
        }
    }
}