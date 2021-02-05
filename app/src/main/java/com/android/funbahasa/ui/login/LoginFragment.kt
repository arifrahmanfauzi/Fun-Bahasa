package com.android.funbahasa.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.android.funbahasa.R
import com.android.funbahasa.databinding.FragmentLoginBinding
import com.android.funbahasa.ui.dashboard.DashboardActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding : FragmentLoginBinding
//    private lateinit var navControler : NavController
    private lateinit var client : GoogleSignInClient
    private lateinit var auth : FirebaseAuth
    private lateinit var viewModel : LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        attachBtn()
        initGmail()
        attachObserver()
    }

    private fun attachObserver() {
        viewModel.responseGoogle.observe(viewLifecycleOwner, Observer { responseGoogle(it) })
        viewModel.isError.observe(viewLifecycleOwner, Observer { isError(it) })
    }

    private fun isError(it: String?) {
        Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun responseGoogle(it: Boolean?) {
        startActivity(Intent(context, DashboardActivity::class.java))
        activity?.finish()
    }


    private fun signIn() {
        val signInIntent = client.signInIntent
        startActivityForResult(signInIntent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                viewModel.firebaseAuthWithGoogle(account.idToken ?: "", auth)
            } catch (e: ApiException) {
                Log.w("failed google", "Google sign in failed", e)
            }
        }
    }

    private fun initGmail() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        client = GoogleSignIn.getClient(requireContext(), gso)
    }

    private fun initView() {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root
        activity?.setContentView(view)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if(user != null){
            startActivity(Intent(context, DashboardActivity::class.java))
            activity?.finish()
        }


//        navControler = Navigation.findNavController(view)

    }

    private fun attachBtn() {
        binding.ivLoginGoogle.setOnClickListener {
            signIn()
        }

//        binding.tvLoginRegister.setOnClickListener{
//            navControler.navigate(R.id.action_loginFragment_to_registerFragment)
//        }
    }
}
