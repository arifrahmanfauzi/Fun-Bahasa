package com.android.funbahasa.ui.dashboard.home

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.funbahasa.R
import com.android.funbahasa.data.model.Response
import com.android.funbahasa.databinding.FragmentHomeBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var viewModel : HomeViewModel
    private var user : FirebaseUser? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        attachObserver()
    }

    private fun attachObserver() {
        viewModel.responseData.observe(viewLifecycleOwner, Observer { showData(it) })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer { confLoading(it) })
        viewModel.isError.observe(viewLifecycleOwner, Observer { isError(it) })
    }

    private fun confLoading(it: Boolean) {
        when(it){
            true -> binding.progressBarHome.visibility = View.INVISIBLE
            else -> binding.progressBarHome.visibility = View.VISIBLE
        }
    }


    private fun showData(it: ArrayList<Response>) {

    }

    private fun isError(it: Throwable) {
        Log.d("IsError", it.localizedMessage)
    }

    private fun initView() {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root
        activity?.setContentView(view)

        auth = FirebaseAuth.getInstance()
        user = auth.currentUser

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getDataView()

        user.let{
            bindView()
        }

    }

    private fun bindView() {
        val first_word = "Hallo, "
        val last_word = "<br><font color='#25AAE2'><b>${user?.displayName}</b></font>"

        binding.tvHomeHallo.setText(Html.fromHtml(first_word  + last_word))


        Glide.with(requireActivity())
            .load(user?.photoUrl)
            .apply(RequestOptions.circleCropTransform())
            .error(R.drawable.try_later)
            .into(binding.ivHomeUser)
    }
}