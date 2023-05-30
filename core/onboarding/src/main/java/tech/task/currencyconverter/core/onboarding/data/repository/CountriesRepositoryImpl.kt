package tech.task.currencyconverter.core.onboarding.data.repository

import tech.task.currencyconverter.core.dto.response.CountriesResponseBody
import tech.task.currencyconverter.core.onboarding.data.remote.CountriesApi
import tech.task.currencyconverter.core.onboarding.domain.repository.CountriesRepository
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val api: CountriesApi
) : CountriesRepository {
    override suspend fun getCountriesDataList(): CountriesResponseBody {
        return api.getCountriesList()
    }
}