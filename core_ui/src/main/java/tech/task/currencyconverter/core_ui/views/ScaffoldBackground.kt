package tech.task.currencyconverter.core_ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldBackground(
    title: String,
    content: @Composable ColumnScope.() -> Unit,
) {

    Scaffold(
        backgroundColor = MaterialTheme.colors.surface,
        topBar = {
            AppBarWithTitle(
                title = title
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = CurrencyConverterTaskTheme.dimens.spaceMedium,
                    horizontal = CurrencyConverterTaskTheme.dimens.spaceMedium
                )
                .background(color = MaterialTheme.colors.background)
        ) {
            content(this)
        }
    }
}

@Preview
@Composable
fun ScaffoldBackgroundPreview() {
    CurrencyConverterTaskTheme() {
        ScaffoldBackground(
            content = { /*TODO*/ },
            title = "Title"
        )
    }
}