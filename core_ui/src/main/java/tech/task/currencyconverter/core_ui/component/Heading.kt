package tech.task.currencyconverter.core_ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.task.currencyconverter.core_ui.R
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme

@Composable
fun Heading(
    text: String,
    modifier: Modifier = Modifier
) {
    
    Text(
        text = text,
        style = MaterialTheme.typography.h5,
        color = MaterialTheme.colors.onPrimary,
        textAlign = TextAlign.Left,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier.wrapContentSize()
    )
}

@Preview(
    name = "Default Preview",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    device = Devices.PIXEL_4_XL
)
@Composable
fun HeadingPreview() {
    CurrencyConverterTaskTheme() {
        Box(modifier = Modifier.padding(64.dp)) {
            Heading(text = stringResource(id = R.string.dummy_heading))
        }
    }
}