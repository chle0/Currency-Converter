package tech.task.currencyconverter.core_ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.task.currencyconverter.core_ui.R
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme

@Composable
fun Description(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 2,
    textAlign: TextAlign = TextAlign.Left,
    fontColor: Color = MaterialTheme.colors.onPrimary.copy(alpha = 0.3f)
) {
    Text(
        text = text,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.body2,
        textAlign = textAlign,
        color = fontColor,
        modifier = modifier
    )
}

@Preview(
    name = "Default Preview",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    device = Devices.PIXEL_4_XL
)
@Composable
fun DescriptionPreview() {
    CurrencyConverterTaskTheme() {
        Box(modifier = Modifier.padding(64.dp)) {
            Description(text = stringResource(id = R.string.dummy_text))
        }
    }
}