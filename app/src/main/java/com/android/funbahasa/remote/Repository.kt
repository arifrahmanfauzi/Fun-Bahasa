package com.android.funbahasa.remote

import com.android.funbahasa.data.model.Response
import com.android.funbahasa.data.service.NetworkConf
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    fun getData(responseHandler : (ArrayList<Response>) -> Unit, errorHandler: (Throwable) -> Unit ){
        NetworkConf.Service().getPuisi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }
}