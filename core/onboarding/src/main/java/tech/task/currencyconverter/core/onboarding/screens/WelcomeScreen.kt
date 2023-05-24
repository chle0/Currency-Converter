package tech.task.currencyconverter.core.onboarding.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import tech.task.currencyconverter.core.onboarding.R
import tech.task.currencyconverter.core_ui.component.ActionButton
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme
import tech.task.currencyconverter.core_ui.views.ScaffoldBackground

@Composable
fun WelcomeScreen(
    onContinueButtonClick: () -> Unit
) {

    ScaffoldBackground(
        title = stringResource(id = R.string.welcome_title)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(
                    vertical = CurrencyConverterTaskTheme.dimens.spaceMedium,
                    horizontal = CurrencyConverterTaskTheme.dimens.spaceMedium
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            

        }
        ActionButton(
            text = stringResource(id = R.string.continue_btn),
            onClick = { onContinueButtonClick() })

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(CurrencyConverterTaskTheme.dimens.spaceExtraMedium)
        )

    }

}