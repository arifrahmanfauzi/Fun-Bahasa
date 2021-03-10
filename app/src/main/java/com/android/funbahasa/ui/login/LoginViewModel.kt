package com.android.funbahasa.ui.login

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.funbahasa.ui.dashboard.DashboardActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginViewModel : ViewModel(){

    // LiveData
    var errorEdt = MutableLiveData<String>()
    var responseEmail  = MutableLiveData<Boolean>()
    var responseLoading = MutableLiveData<Boolean>()
    var responseGoogle = MutableLiveData<Boolean>()
    var isError        = MutableLiveData<String>()

    fun firebaseAuthWithGoogle(idToken: String, auth : FirebaseAuth) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                  responseGoogle.value = true
                } else {
                    isError.value = "Something Wrong"
                }
            }
    }

    fun loginWithEmail(email: String, password: String, auth: FirebaseAuth) {
        if (email.isNullOrEmpty() || email.trim() == "") {
            errorEdt.value = "email"
        } else if (password.isNullOrEmpty() || password.trim() == "") {
            errorEdt.value = "password"
        }
        auth?.signInWithEmailAndPassword(email, password)
            ?.addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    responseEmail.value = true
                } else {
                    isError.value = "Something Error"
                }
            }
    }


    fun isLoading(status : Boolean){
        responseLoading.value = status
    }
}