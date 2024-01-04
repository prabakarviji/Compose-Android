package com.spritle.aurora2


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SignInRoute(
    email: String?,
    onSignInSubmitted: () -> Unit,
    onNavUp: () -> Unit,
) {
    val signInViewModel: SignInViewModel = viewModel()
    SignInScreen(
        email = email,
        onSignInSubmitted = { email, password ->
            signInViewModel.signIn(email, password, onSignInSubmitted)
        },
        onNavUp = onNavUp,
    )
}
