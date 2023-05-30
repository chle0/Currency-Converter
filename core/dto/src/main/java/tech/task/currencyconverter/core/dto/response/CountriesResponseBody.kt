package tech.task.currencyconverter.core.dto.response

import com.google.gson.annotations.SerializedName

data class CountriesResponseBody(
    @SerializedName("data")
    val data: List<CountriesData>,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("msg")
    val msg: String
) {
    data class CountriesData(
        @SerializedName("currency")
        val currency: String,
        @SerializedName("iso2")
        val iso2: String,
        @SerializedName("iso3")
        val iso3: String,
        @SerializedName("name")
        val name: String
    )
}