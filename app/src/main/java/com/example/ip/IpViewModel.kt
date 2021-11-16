package com.example.ip

import android.app.Application
import android.widget.Button
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.ip.data.remote.ip.IpApi
import com.example.ip.data.remote.ip.IpResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class IpViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var compositeDisposable: Disposable
    val mutableLiveData: MutableLiveData<IpResponse> = MutableLiveData()

    init {
        fetchMyIp((getApplication() as IpApp).ipApi).toString()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchMyIp(ipApi: IpApi) {
        ipApi.let {
            compositeDisposable = ipApi.getIP()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableLiveData.value = it
                }, {
                })
        }
    }
}