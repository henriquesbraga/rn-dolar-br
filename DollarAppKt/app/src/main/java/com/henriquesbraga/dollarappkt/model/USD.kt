package com.henriquesbraga.dollarappkt.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable()
data class USD (
    @SerialName("code")
    var code: String,

    @SerialName("codein")
    var codein: String,

    @SerialName("name")
    var name: String ,

    @SerialName("high")
    var high: String,

    @SerialName("low")
    var low: String,

    @SerialName("varBid")
    var varBid: String,

    @SerialName("pctChange")
    var pctChange: String,

    @SerialName("bid")
    var bid: String,

    @SerialName("ask")
    var ask: String,

    @SerialName("timestamp")
    var timestamp: String,

    @SerialName("create_date")
    var create_date: String,
) {
    override fun toString(): String {
        return "Code='$code', \n Codein='$codein', \n Name='$name', \n High='$high', \n Low='$low', \n VarBid='$varBid', \n PctChange='$pctChange', \n Bid='$bid', \n Ask='$ask', \n Timestamp='$timestamp', \n Create_date='$create_date')"
    }
}