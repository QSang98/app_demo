package com.example.demoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapp.Constant
import com.example.demoapp.model.Data
import com.example.demoapp.model.UserModel
import com.example.demoapp.usecase.GetUserUseCase
import com.example.demoapp.usecase.UserLogInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userLogInUseCase: UserLogInUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()

    val logInData: LiveData<Data> get() = _logInData
    private val _logInData = MutableLiveData<Data>()

    val userData: LiveData<UserModel> get() = _userData
    private val _userData = MutableLiveData<UserModel>()

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

    fun getUserProfile() {
        getUserUseCase.invoke(Constant.API_USER)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                onSuccess = {
                    _userData.postValue(it)
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
