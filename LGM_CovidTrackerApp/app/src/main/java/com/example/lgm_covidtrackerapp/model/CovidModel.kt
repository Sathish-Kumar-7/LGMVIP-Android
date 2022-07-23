package com.example.lgm_covidtrackerapp.model

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class CovidModel(private val context: Context) {
    private var listOfStates:MutableList<State> = mutableListOf()
    private fun getListOfStates(): List<State> {
        return listOfStates
    }
    init {
        fetchAllStatesData()
    }
    private fun fetchAllStatesData() {
        val url = "https://data.covid19india.org/state_district_wise.json"
        val queue = Volley.newRequestQueue(context)
        val stringReq = StringRequest(Request.Method.GET, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    val keys = obj.keys()
                    keys.next()
                    while (keys.hasNext()) {
                        val key = keys.next()
                        val obj1 = obj.getJSONObject(key)
                        val obj2 = obj1.getJSONObject("districtData")
                        val districtKeys = obj2.keys()
                        val listOfDistricts = mutableListOf<District>()
                        while (districtKeys.hasNext()) {
                            val district = districtKeys.next()
                            val districtObj = obj2.getJSONObject(district)
                            val districtDeltaObj = districtObj.getJSONObject("delta")
                            listOfDistricts.add(
                                District(
                                    name = district,
                                    active = districtObj.getString("active").toLong(),
                                    confirmed = districtObj.getString("confirmed").toLong(),
                                    migrate = districtObj.getString("migratedother").toLong(),
                                    deceased = districtObj.getString("deceased").toLong(),
                                    recovered = districtObj.getString("recovered").toLong(),
                                    delta = Delta(
                                        confirmed = districtDeltaObj.getString("confirmed").toLong(),
                                        deceased = districtDeltaObj.getString("deceased").toLong(),
                                        recovered = districtDeltaObj.getString("recovered").toLong()
                                    )
                                )
                            )
                        }
                        listOfStates.add(
                            State(
                                name = key,
                                districts = listOfDistricts,
                                stateCode = obj1.getString("statecode")
                            )
                        )
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                Log.d("State", "Done")
                CovidViewModel.list.value = listOfStates
                CovidViewModel.listOfStateNames.value = getListOfStatesNames()
            },
            { Log.d("API", "that didn't work") })
        queue.add(stringReq)
        CovidViewModel.list.value = listOfStates
    }

    fun getListOfStatesNames(): List<String> {
        return listOfStates.map {
            it.name
        }
    }
}