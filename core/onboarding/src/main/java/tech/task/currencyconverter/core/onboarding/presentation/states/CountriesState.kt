package tech.task.currencyconverter.core.onboarding.presentation.states

import tech.task.currencyconverter.core.dto.response.CountriesResponseBody

data class CountriesState(
    val isLoading: Boolean = false,
    var success: CountriesResponseBody? = null,
    var error: String? = "",
    val none: Boolean = false
)