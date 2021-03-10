package com.android.funbahasa.ui.login.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class RegisterViewModel() : ViewModel(){

    var responseRegister = MutableLiveData<Boolean>()
    var responseError = MutableLiveData<String>()
    var responseEditText = MutableLiveData<String>()


    fun actionRegister(name: String, email: String, password: String, auth: FirebaseAuth) {
        if (name.isNullOrEmpty() || name.trim() =="")
            responseEditText.value = "name"
        else if (email.isNullOrEmpty() || email.trim() =="")
            responseEditText.value = "email"
        else if (password.isNullOrEmpty() || password.trim() =="")
            responseEditText.value = "password"
        else {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        val reqUpdate =
                            UserProfileChangeRequest.Builder().setDisplayName(name).build()
                        var user = auth?.currentUser
                        user?.updateProfile(reqUpdate)
                        responseRegister.value = true
                    } else {
                        responseError.value = "Something Wrong ...."
                    }
                }
        }
    }

}