package com.example.lgm_covidtrackerapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

object CovidViewModel : ViewModel() {
    val choosenState: MutableLiveData<String> = MutableLiveData()
    var list :MutableLiveData< List<State> > = MutableLiveData()
    var listOfStateNames: MutableLiveData<List<String>> = MutableLiveData(listOf())

    fun getStateData(stateName:String):State?{
        return list.value?.first {
            it.name == stateName
        }
    }
}