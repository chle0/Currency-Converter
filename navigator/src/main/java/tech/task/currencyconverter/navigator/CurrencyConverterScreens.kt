package tech.task.currencyconverter.navigator

import androidx.navigation.NamedNavArgument

object DestinationArgs {

}

sealed class CurrencyConverterRoute(val name: String) {
    object OnBoarding : CurrencyConverterRoute("OnBoarding")
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}

sealed class CurrencyConverterScreens(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name: String = route.appendArguments(navArguments)

    object SplashScreen : CurrencyConverterScreens("SplashScreen")
    object WelcomeScreen : CurrencyConverterScreens("WelcomeScreen")
}