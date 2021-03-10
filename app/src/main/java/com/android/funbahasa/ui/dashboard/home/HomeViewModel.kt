package com.android.funbahasa.ui.dashboard.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.funbahasa.data.model.Response
import com.android.funbahasa.remote.Repository

class HomeViewModel () : ViewModel(){

    val repository = Repository()

    var responseData = MutableLiveData<ArrayList<Response>>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getDataView(){
        repository.getData({
            responseData.value = it
        },{
            isError.value = it
        })
    }
}