package com.example.lgm_covidtrackerapp.model

data class State(
    val name:String,
    val districts:List<District>,
    val stateCode:String
){
    val active:Long = districts
        .sumOf {
                it.active
        }
    val confirmed:Long = districts
        .sumOf {
            it.confirmed
        }
    val migrate:Long = districts
        .sumOf {
            it.migrate
        }
    val deceased:Long = districts
        .sumOf {
            it.deceased
        }
    val recovered:Long = districts
        .sumOf {
            it.recovered
        }
    val delta:Delta = Delta(
        confirmed = districts.sumOf {
            it.delta?.confirmed?:0
        },
        deceased = districts.sumOf {
            it.delta?.deceased?:0
        },
        recovered = districts.sumOf {
            it.delta?.recovered?:0
        }
    )
}
