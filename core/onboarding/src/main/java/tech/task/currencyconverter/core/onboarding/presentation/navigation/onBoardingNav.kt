package tech.task.currencyconverter.core.onboarding.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import tech.task.currencyconverter.navigator.CurrencyConverterRoute
import tech.task.currencyconverter.navigator.CurrencyConverterScreens
import tech.task.currencyconverter.core.onboarding.presentation.screens.SplashScreen
import tech.task.currencyconverter.core.onboarding.presentation.screens.WelcomeScreen

fun NavGraphBuilder.onBoardingNav(
    navController: NavHostController
) {
    navigation(
        startDestination = CurrencyConverterScreens.SplashScreen.name,
        route = CurrencyConverterRoute.OnBoarding.name
    ) {
        composable(route = CurrencyConverterScreens.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(route = CurrencyConverterScreens.WelcomeScreen.name) {
            WelcomeScreen(onContinueButtonClick = {})
        }

    }

}