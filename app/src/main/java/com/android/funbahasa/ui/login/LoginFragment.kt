package com.android.funbahasa.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.android.funbahasa.R
import com.android.funbahasa.databinding.FragmentLoginBinding
import com.android.funbahasa.ui.dashboard.DashboardActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding : FragmentLoginBinding
    private lateinit var navControler : NavController
    private lateinit var client : GoogleSignInClient
    private lateinit var auth : FirebaseAuth
    private lateinit var viewModel : LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        val viewBinding = binding.root
        activity?.setContentView(viewBinding)
        navControler = Navigation.findNavController(view)

        initView()
        attachBtn()
        initGmail()
        attachObserver()
    }

    private fun attachObserver() {
        viewModel.errorEdt.observe(viewLifecycleOwner, Observer { errorEdt(it) })
        viewModel.responseGoogle.observe(viewLifecycleOwner, Observer { responseGoogle(it) })
        viewModel.isError.observe(viewLifecycleOwner, Observer { isError(it) })
        viewModel.responseEmail.observe(viewLifecycleOwner, Observer { showEmail(it) })
    }

    private fun errorEdt(error: String) {
        when(error){
            "email" ->{
                binding.etLoginEmail.error = "email tidak boleh kosong"
                binding.etLoginEmail.requestFocus()
            }
            "password" -> {
                binding.etLoginPassword.error = "email tidak boleh kosong"
                binding.etLoginPassword.requestFocus()
            }
        }
    }

    private fun showEmail(status: Boolean) {
        if (status){
            startActivity(Intent(context, DashboardActivity::class.java))
            activity?.finish()
        }
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
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if(user != null){
            startActivity(Intent(context, DashboardActivity::class.java))
            activity?.finish()
        }
    }

    private fun attachBtn() {
        binding.ivLoginGoogle.setOnClickListener {
                signIn()
        }

        binding.btnLoginLogin.setOnClickListener {
            viewModel.loginWithEmail(binding.etLoginEmail.text.toString(), binding.etLoginPassword.text.toString(), auth)
        }

        binding.tvLoginRegister.setOnClickListener{
            navControler.navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}
