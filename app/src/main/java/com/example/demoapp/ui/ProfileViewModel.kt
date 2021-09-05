package com.example.demoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapp.Constant
import com.example.demoapp.model.Data1
import com.example.demoapp.model.Data2
import com.example.demoapp.model.LogInModel
import com.example.demoapp.usecase.GetUserUseCase
import com.example.demoapp.usecase.UpdateUserUseCase
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
    private val userLogInUseCase: UserLogInUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()

    val logInData: LiveData<LogInModel> get() = _logInData
    private val _logInData = MutableLiveData<LogInModel>()

    val userData: LiveData<Data1> get() = _userData
    private val _userData = MutableLiveData<Data1>()

    private val _updateData = MutableLiveData<Data2>()

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
                    if (it.message.equals("SUCCESS")) {
                        _logInData.postValue(it)
                        Timber.i("success!")
                    }
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
                    if (it.message.equals("SUCCESS")) {
                        _userData.postValue(it.data1)
                        Timber.i("success!")
                    }
                },
                onError = {
                    Timber.e("error")
                }
            )
            .addTo(disposables)
    }

    fun updateUserProfile(
        api: String,
        token: String,
        sum: String,
        size: Long,
        time: Long,
        requestBody: RequestBody
    ) {
        updateUserUseCase.invoke(
            api, token, sum, size, time, requestBody
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                onSuccess = {
                    _updateData.postValue(it.data2)
                    Timber.i("Success")
                },
                onError = {
                    Timber.e("Error")
                }
            )
            .addTo(disposables)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
