package com.example.lgm_covidtrackerapp.model

data class District(
    val name:String,
    val active:Long,
    val confirmed:Long,
    val migrate:Long,
    val deceased:Long,
    val recovered:Long,
    val delta:Delta?
)
