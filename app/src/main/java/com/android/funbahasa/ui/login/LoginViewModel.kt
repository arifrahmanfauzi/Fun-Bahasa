package com.android.funbahasa.ui.login

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.funbahasa.ui.dashboard.DashboardActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginViewModel () : ViewModel(){

    // LiveData
    var responseGoogle = MutableLiveData<Boolean>()
    var isError        = MutableLiveData<String>()

    fun firebaseAuthWithGoogle(idToken: String, auth : FirebaseAuth) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                  responseGoogle.value = true
                } else {
                    isError.value = "Something Wrong"
                }
            }
    }
}