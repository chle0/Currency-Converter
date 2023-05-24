package tech.task.currencyconverter.core_ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme
import tech.task.currencyconverter.utils.shadow

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.background
        ),
        enabled = isEnabled,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .shadow(
                color = MaterialTheme.colors.primary,
                alpha = 0.5f,
                borderRadius = 100.dp,
                shadowRadius = 12.dp,
                offsetY = 8.dp
            )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}

@Composable
fun SmallWidthButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    buttonBgColor: Color = Color.Transparent,
    textColor: Color = Color.Black
) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonBgColor,
            contentColor = textColor
        ),
        enabled = isEnabled,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        modifier = modifier
            .height(48.dp)
            .shadow(
                color = buttonBgColor,
                alpha = 0.5f,
                borderRadius = 100.dp,
                shadowRadius = 12.dp,
                offsetY = 8.dp
            )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            maxLines = 1,
            modifier = Modifier.padding(8.dp),
            lineHeight = 26.8.sp
        )
    }
}

@Preview(
    name = "Default Preview",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    device = Devices.PIXEL_4_XL
)
@Composable
fun ActionButtonPreview() {
    CurrencyConverterTaskTheme() {
        Box(modifier = Modifier.padding(64.dp)) {
            ActionButton(text = "Next", onClick = { })
        }
    }
}