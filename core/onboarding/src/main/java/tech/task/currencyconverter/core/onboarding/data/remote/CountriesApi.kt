package tech.task.currencyconverter.core.onboarding.data.remote

import retrofit2.http.GET
import tech.task.currencyconverter.core.dto.response.CountriesResponseBody

interface CountriesApi {
    @GET("api/v0.1/countries/currency")
    suspend fun getCountriesList():CountriesResponseBody
}