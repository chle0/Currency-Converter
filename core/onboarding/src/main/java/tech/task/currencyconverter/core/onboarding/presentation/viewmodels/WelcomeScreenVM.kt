package tech.task.currencyconverter.core.onboarding.presentation.viewmodels

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import tech.task.currencyconverter.core.dto.response.CountriesResponseBody
import tech.task.currencyconverter.core.onboarding.domain.use_cases.CountriesUseCase
import tech.task.currencyconverter.core.onboarding.presentation.states.CountriesState
import tech.task.currencyconverter.core_ui.views.countryList
import tech.task.currencyconverter.network.Resource
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenVM @Inject constructor(
    private val countriesUseCase: CountriesUseCase,
    private val mApplication: Application
) : ViewModel() {

    var selectedCountry: CountriesResponseBody.CountriesData? = null
    var country = mutableStateOf("Pakistan")
        private set

    var language = mutableStateOf("English")
        private set

    private val _stateCountries = mutableStateOf(CountriesState())
    val stateCountriesList: State<CountriesState> = _stateCountries

    init {
        getCountriesList()
    }

    private fun getCountriesList() {
        countriesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateCountries.value = CountriesState(success = result.data)
                    countryList.clear()
                    result.data?.data?.forEachIndexed { _, countryData ->
                        countryList.add(countryData)
                    }
                }

                is Resource.Error -> {
                    _stateCountries.value = CountriesState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _stateCountries.value = CountriesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun resetDropDownResponse() {
        stateCountriesList.value.success = null
        stateCountriesList.value.error = null
    }
}