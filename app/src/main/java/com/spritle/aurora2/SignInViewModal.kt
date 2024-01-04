package com.spritle.aurora2


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.net.ssl.HandshakeCompletedEvent
import android.util.Log

class SignInViewModel() : ViewModel() {

    /**
     * Consider all sign ins successful
     */
    fun signIn(
        email: String,
        password: String,
        onSignInCompleted: () -> Unit,
    ) {
        if(email == "jan@gmail.com" && password == "1234"){
              Log.d(email,password)
            onSignInCompleted()
        }

    }

}
//
//class SignInViewModelFactory : ViewModelProvider.Factory {
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
//            return SignInViewModel() as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}