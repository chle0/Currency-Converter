package tech.task.currencyconverter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import tech.task.currencyconverter.core_ui.theme.CurrencyConverterTaskTheme
import tech.task.currencyconverter.core.onboarding.navigation.onBoardingNav
import tech.task.currencyconverter.navigator.CurrencyConverterRoute

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    @OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTaskTheme(isPreview = false) {
                val bottomSheetNavigator = BottomSheetNavigator(
                    sheetState = rememberModalBottomSheetState(
                        initialValue = ModalBottomSheetValue.Hidden,
                        skipHalfExpanded = true
                    )
                )
                val navController = rememberNavController(bottomSheetNavigator)

                ModalBottomSheetLayout(
                    bottomSheetNavigator = bottomSheetNavigator,
                    sheetShape = RoundedCornerShape(
                        topStart = CurrencyConverterTaskTheme.dimens.grid_2,
                        topEnd = CurrencyConverterTaskTheme.dimens.grid_2
                    ),
                    scrimColor = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    sheetElevation = CurrencyConverterTaskTheme.dimens.grid_1
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = CurrencyConverterRoute.OnBoarding.name,
                    ) {
                        onBoardingNav(navController)

                    }

                }

            }

        }
    }
}
