package com.android.funbahasa.ui.login.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.android.funbahasa.R
import com.android.funbahasa.databinding.FragmentResultBinding
import kotlinx.android.synthetic.main.fragment_result.*


class ResultFragment : Fragment(R.layout.fragment_result) {

    private lateinit var navController : NavController
    private lateinit var binding : FragmentResultBinding
    private  var getName : String ?= null
    private  var getEmail : String ?= null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding = FragmentResultBinding.inflate(layoutInflater)
        val viewBinding = binding.root
        activity?.setContentView(viewBinding)

        initVar()
        initView()
    }

    private fun initVar() {
        getName = arguments?.getString("name")
        getEmail = arguments?.getString("email")
    }

    private fun initView(){
        et_Result_name.setText(getName)
        et_Result_email.setText(getEmail)
    }
}