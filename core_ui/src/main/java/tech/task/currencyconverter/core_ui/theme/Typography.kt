package tech.task.currencyconverter.core_ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import tech.task.currencyconverter.core_ui.R

val currencyConverterTaskFamily =
    FontFamily(
        Font(R.font.inter_bold, weight = FontWeight.Bold),
        Font(R.font.inter_light, weight = FontWeight.Light),
        Font(R.font.inter_extrabold, weight = FontWeight.ExtraBold),
        Font(R.font.inter_medium, weight = FontWeight.Medium),
        Font(R.font.inter_thin, weight = FontWeight.Thin),
        Font(R.font.inter, weight = FontWeight.Normal),
        Font(R.font.inter_black, weight = FontWeight.Black),
        Font(R.font.inter_extralight, weight = FontWeight.ExtraLight),
        Font(R.font.inter_semibold, weight = FontWeight.SemiBold)
    )

val CurrencyConverterTaskTypography = Typography(
    defaultFontFamily = currencyConverterTaskFamily,
    body1 = TextStyle(
        fontFamily = currencyConverterTaskFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = currencyConverterTaskFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = currencyConverterTaskFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h1 = TextStyle(
        fontFamily = currencyConverterTaskFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    h2 = TextStyle(
        fontFamily = currencyConverterTaskFamily,
        fontWeight = FontWeight.W500,
        fontSize = 18.sp
    ),
    h3 = TextStyle(
        fontFamily = currencyConverterTaskFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    h4 = TextStyle(
        fontFamily = currencyConverterTaskFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    ),
    h5 = TextStyle(
        fontFamily = currencyConverterTaskFamily,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp
    )
)