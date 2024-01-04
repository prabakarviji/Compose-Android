package com.spritle.aurora2
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spritle.aurora2.Destinations.SIGN_IN_ROUTE
import com.spritle.aurora2.Destinations.HOME_ROUTE


object Destinations {
//    const val WELCOME_ROUTE = "welcome"
    const val SIGN_IN_ROUTE = "signin/{email}"
    const val HOME_ROUTE = "home"
}

@Composable
fun JetsurveyNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = SIGN_IN_ROUTE,
    ) {
//        composable(WELCOME_ROUTE) {
//            WelcomeRoute(
//                onNavigateToSignIn = {
//                    navController.navigate("signin/$it")
//                },
//
//            )
//        }

        composable(SIGN_IN_ROUTE) {
            val startingEmail = it.arguments?.getString("email")
            SignInRoute(
                email = startingEmail,
                onSignInSubmitted = {
                    navController.navigate(HOME_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(HOME_ROUTE) {
            HomeScreen()
            //{
               // navController.popBackStack(SIGN_IN_ROUTE, false)
            //}
        }

    }
}