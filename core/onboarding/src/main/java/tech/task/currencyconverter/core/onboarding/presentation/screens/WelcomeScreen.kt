package tech.task.currencyconverter.core.onboarding.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import tech.task.currencyconverter.core.onboarding.R
import tech.task.currencyconverter.core.onboarding.presentation.viewmodels.WelcomeScreenVM
import tech.task.currencyconverter.core_ui.component.ActionButton
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme
import tech.task.currencyconverter.core_ui.views.CountriesSpinnerField
import tech.task.currencyconverter.core_ui.views.ScaffoldBackground

@Composable
fun WelcomeScreen(
    onContinueButtonClick: () -> Unit
) {

    val welcomeVM: WelcomeScreenVM = hiltViewModel()
    val context = LocalContext.current
    val stateCountry = welcomeVM.stateCountriesList.value

    ScaffoldBackground(
        title = stringResource(id = R.string.welcome_title)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            //Countries List
            if (stateCountry.success?.data?.isNotEmpty() == true) {
                Toast.makeText(
                    context,
                    stateCountry.success?.msg,
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
            if (stateCountry.error?.isNotBlank() == true) {
                Toast.makeText(
                    context,
                    stateCountry.error.toString(),
                    Toast.LENGTH_SHORT
                )
                    .show()
                welcomeVM.resetDropDownResponse()
            }

            if (stateCountry.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .zIndex(1f)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(
                        vertical = CurrencyConverterTaskTheme.dimens.spaceMedium,
                        horizontal = CurrencyConverterTaskTheme.dimens.spaceMedium
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(CurrencyConverterTaskTheme.dimens.spaceLarge * 2)
                )

                CountriesSpinnerField(
                    label = stringResource(id = R.string.country),
                    countryName = welcomeVM.country.value,
                    onValueChange = {
                        welcomeVM.country.value = it
                    },
                    onDropDownItemClick = {
                        welcomeVM.selectedCountry = it
                        welcomeVM.country.value = it.name
                    }
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(CurrencyConverterTaskTheme.dimens.spaceMedium)
                )
                CountriesSpinnerField(
                    label = stringResource(id = R.string.language),
                    countryName = welcomeVM.language.value,
                    onValueChange = {
                        welcomeVM.language.value = it
                    },
                    onDropDownItemClick = {},
                    isLanguage = true
                )


            }
            ActionButton(
                text = stringResource(id = R.string.continue_btn).uppercase(),
                onClick = { onContinueButtonClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(CurrencyConverterTaskTheme.dimens.spaceExtraMedium)
            )

        }
    }
}