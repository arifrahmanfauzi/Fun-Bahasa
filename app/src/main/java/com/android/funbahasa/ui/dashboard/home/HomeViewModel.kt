package com.android.funbahasa.ui.dashboard.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.funbahasa.R
import com.android.funbahasa.data.model.Response
import com.android.funbahasa.data.model.ResponsePuisi
import com.android.funbahasa.remote.Repository

class HomeViewModel () : ViewModel(){

    val repository = Repository()

    var responseData = MutableLiveData<ArrayList<Response>>()
    var responseDummy = MutableLiveData<List<ResponsePuisi>>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getDataView(){
        repository.getData({
            responseData.value = it
            isLoading.value = true
        },{
            isError.value = it
        })
    }
}