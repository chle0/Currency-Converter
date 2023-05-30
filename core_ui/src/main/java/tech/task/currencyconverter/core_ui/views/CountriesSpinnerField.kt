package tech.task.currencyconverter.core_ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.window.PopupProperties
import tech.task.currencyconverter.core.dto.response.CountriesResponseBody
import tech.task.currencyconverter.core_ui.R
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme
import java.util.Locale

var countryList = mutableListOf<CountriesResponseBody.CountriesData>()

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CountriesSpinnerField(
    modifier: Modifier = Modifier,
    countryName: String,
    label: String,
    onValueChange: (String) -> Unit,
    style: TextStyle = MaterialTheme.typography.h2.copy(
        lineHeight = 26.8.sp, fontWeight = FontWeight.W700
    ),
    maxLines: Int = 1,
    onDropDownItemClick: (CountriesResponseBody.CountriesData) -> Unit,
    onClick: (() -> Unit?)? = null,
    isLanguage: Boolean = false
) {
    val focusRequester = remember { FocusRequester() }
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }
    val searchText = remember {
        mutableStateOf(TextFieldValue(""))
    }
    var filteredItems: List<CountriesResponseBody.CountriesData> by remember {
        mutableStateOf(
            emptyList()
        )
    }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Text(
            text = label,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.button.copy(
                lineHeight = 26.8.sp
            ),
            modifier = modifier.padding(
                top = CurrencyConverterTaskTheme.dimens.grid_1,
                bottom = CurrencyConverterTaskTheme.dimens.grid_1
            ),
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
                .padding(
                    horizontal = CurrencyConverterTaskTheme.dimens.spaceSmall
                )
                .clickable(
                    onClick = {
                        if (onClick != null) {
                            onClick()
                        }
                        expanded = !expanded
                    }, interactionSource = interactionSource, indication = null
                ),
            elevation = CurrencyConverterTaskTheme.dimens.plane_0,
            shape = RoundedCornerShape(CurrencyConverterTaskTheme.dimens.spaceDefault),
            border = BorderStroke(
                CurrencyConverterTaskTheme.dimens.plane_1,
                MaterialTheme.colors.onPrimary
            ),
            backgroundColor = Color.Transparent
        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = countryName,
                onValueChange = onValueChange,
                readOnly = true,
                enabled = false,
                singleLine = true,
                maxLines = maxLines,
                visualTransformation = VisualTransformation.None,
                shape = RoundedCornerShape(CurrencyConverterTaskTheme.dimens.grid_1_5),
                textStyle = style,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onPrimary,
                    cursorColor = MaterialTheme.colors.onPrimary,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Transparent,
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .focusRequester(focusRequester)
            )
            if (!isLanguage) {
                if (expanded)
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_up),
                        contentDescription = "Up",
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.padding(end = CurrencyConverterTaskTheme.dimens.spaceSmall)
                    )
                else Icon(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = "down",
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.padding(end = CurrencyConverterTaskTheme.dimens.spaceSmall)
                )
            }
        }
    }
    if (!isLanguage) {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
                searchText.value = TextFieldValue("")
            },
            properties = PopupProperties(
                dismissOnBackPress = true, dismissOnClickOutside = true, focusable = true
            ),
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .height(screenHeight / 2)
                .background(Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                    .height(screenHeight / 2)
            ) {
                Column(
                    modifier = Modifier
                        .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                        .height(screenHeight / 2)
                        .padding(CurrencyConverterTaskTheme.dimens.spaceDefault)
                ) {
                    Text(
                        text = stringResource(id = R.string.select_country),
                        style = style,
                        color = MaterialTheme.colors.onPrimary
                    )
                    Spacer(modifier = Modifier.height(CurrencyConverterTaskTheme.dimens.spaceMedium))
                    filteredItems = if (searchText.value.text.isEmpty()) {
                        countryList
                    } else {
                        val resultList =
                            ArrayList<CountriesResponseBody.CountriesData>()
                        for (item in countryList) {
                            if (item.name.lowercase(Locale.getDefault())
                                    .contains(searchText.value.text.lowercase(Locale.getDefault()))
                            ) {
                                resultList.add(item)
                            }

                        }
                        resultList
                    }
                    SearchView(
                        state = searchText
                    ) {
                        searchText.value.copy(
                            text = it.text
                        )
                        filteredItems = if (searchText.value.text.isEmpty()) {
                            countryList
                        } else {
                            countryList.filter { item ->
                                item.name.lowercase(Locale.getDefault())
                                    .contains(searchText.value.text.lowercase(Locale.getDefault()))
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(CurrencyConverterTaskTheme.dimens.spaceSmall))

                    LazyColumn {
                        items(filteredItems) { item ->
                            DropdownMenuItem(
                                onClick = {
                                    onDropDownItemClick(item)
                                    keyboardController?.hide()
                                    focusRequester.requestFocus()
                                    expanded = false
                                    searchText.value = TextFieldValue("")
                                }
                            ) {
                                Text(
                                    text = item.name,
                                    color = MaterialTheme.colors.onPrimary,
                                    style = MaterialTheme.typography.button
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
}