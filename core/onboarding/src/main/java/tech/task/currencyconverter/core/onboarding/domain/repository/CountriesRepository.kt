package tech.task.currencyconverter.core.onboarding.domain.repository

import tech.task.currencyconverter.core.dto.response.CountriesResponseBody

interface CountriesRepository {

    suspend fun getCountriesDataList(): CountriesResponseBody
}