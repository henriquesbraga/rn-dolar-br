package com.henriquesbraga.dollarappkt.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(@SerialName("USD") var usd:USD ){
    override fun toString(): String {
        return "Dados: $usd"
    }
}


