package tech.task.currencyconverter.core_ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import tech.task.currencyconverter.core_ui.R
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    state: MutableState<TextFieldValue>,
    onValueChange: ((TextFieldValue) -> Unit)? = null
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Card(
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(
            CurrencyConverterTaskTheme.dimens.plane_1,
            MaterialTheme.colors.onPrimary.copy(alpha = 0.3f)
        ),
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(CurrencyConverterTaskTheme.dimens.grid_2),
        elevation = CurrencyConverterTaskTheme.dimens.grid_1,
    ) {
        TextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
                if (onValueChange != null) {
                    onValueChange(state.value)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = CurrencyConverterTaskTheme.dimens.grid_1),
            textStyle = TextStyle(
                color = MaterialTheme.colors.onSecondary,
                fontStyle = MaterialTheme.typography.button.fontStyle,
                fontWeight = MaterialTheme.typography.button.fontWeight,
                fontSize = MaterialTheme.typography.button.fontSize,
                fontFamily = MaterialTheme.typography.button.fontFamily,
            ),
            trailingIcon = {
                IconButton(
                    onClick = {
                        state.value = TextFieldValue("")
                        if (onValueChange != null) {
                            onValueChange(state.value)
                        }
                    }
                ) {
                    Icon(
                        if (state.value != TextFieldValue("")) {
                            Icons.Filled.Close
                        } else {
                            Icons.Filled.Search
                        },
                        contentDescription = "close",
                        tint = MaterialTheme.colors.onPrimary.copy(alpha = 0.3f),
                        modifier = Modifier.padding(end = CurrencyConverterTaskTheme.dimens.grid_1)
                    )
                }
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.quick_search),
                    color = MaterialTheme.colors.onPrimary.copy(alpha = 0.3f),
                    style = MaterialTheme.typography.button
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { keyboardController?.hide() }),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onSecondary,
                cursorColor = MaterialTheme.colors.onSecondary,
                leadingIconColor = MaterialTheme.colors.onSecondary,
                trailingIconColor = MaterialTheme.colors.onPrimary.copy(alpha = 0.3f),
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}