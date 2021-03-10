package com.android.funbahasa.ui.login.register

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.android.funbahasa.R
import com.android.funbahasa.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private  var auth = FirebaseAuth.getInstance()
    private lateinit var viewModel : RegisterViewModel
    private lateinit var navController : NavController
    private lateinit var binding : FragmentRegisterBinding

    private var name : String ?= null
    private var email : String ?= null
    private var password : String ?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        val viewBinding = binding.root
        activity?.setContentView(viewBinding)
        navController = Navigation.findNavController(view)

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        attachBtn()
        attachObserVe()
    }

    private fun attachObserVe() {
        viewModel.responseRegister.observe(viewLifecycleOwner, Observer { showRegister(it) })
        viewModel.responseEditText.observe(viewLifecycleOwner, Observer { showEt(it) })
    }

    private fun showEt(error: String?) {
        when(error){
            "name" -> {
                binding.etRegisterName.error = "Silahkan isi nama anda"
                binding.etRegisterName.requestFocus()
            }

            "email" -> {
                binding.etRegisterEmail.requestFocus()
                binding.etRegisterEmail.error = "silahkan isi email anda"
            }

            "password" -> {
                binding.etRegisterPassword.requestFocus()
                binding.etRegisterPassword.error = "silahkan isi password anda"
            }
        }
    }

    private fun showRegister(status: Boolean) {
        Log.d("Show Register", "$status")
       if (status){
           val bundle = bundleOf("name" to name, "email" to email)
           navController.navigate(R.id.action_registerFragment_to_resultFragment, bundle)
       }
    }

    private fun attachBtn() {
        binding.btnRegister.setOnClickListener{

            name = binding.etRegisterName.text.toString()
            email = binding.etRegisterEmail.text.toString()
            password = binding.etRegisterPassword.text.toString()

            viewModel.actionRegister(name ?: "",
                email ?: "",
                password ?: "", auth)
        }
    }
}