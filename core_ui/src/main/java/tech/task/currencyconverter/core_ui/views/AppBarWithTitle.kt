package tech.task.currencyconverter.core_ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.task.currencyconverter.core_ui.R
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme

@Composable
fun AppBarWithTitle(
    title: String
) {
    return TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary
            )
            Image(
                painter = painterResource(id = R.drawable.welcome_shake_icon),
                contentDescription = "icon"
            )
        }
    }
}

@Composable
@Preview
fun AppBarWithTitlePreview() {
    CurrencyConverterTaskTheme() {
        AppBarWithTitle(title = "Title")
    }

}