package com.example.demoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapp.Constant
import com.example.demoapp.model.Data
import com.example.demoapp.model.LogInModel
import com.example.demoapp.usecase.GetUsersListUseCase
import com.example.demoapp.usecase.UserLogInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userLogInUseCase: UserLogInUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()

    val logInData: LiveData<Data> get() = _logInData
    private val _logInData = MutableLiveData<Data>()

    init {
        userLogInAuthetication()
    }

    fun userLogInAuthetication() {
        userLogInUseCase.invoke(
            Constant.EMAIL,
            Constant.PWD,
            Constant.APPLICATION,
            Constant.APPLICATION_TYPE,
            Constant.APPLICATION_VERSION,
            Constant.DEVICE_ID,
            Constant.DEVICE_NAME,
            Constant.DEVICE_TYPE,
            Constant.OS_VERSION,
            Constant.API
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                onSuccess = {
                    _logInData.postValue(it.data)
                    Timber.i("success!")
                },
                onError = {
                    Timber.e("error")
                }
            )
            .addTo(disposables)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
