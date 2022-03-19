package com.example.workshopapp.workshop2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workshopapp.R
import com.example.workshopapp.domain.login.LoginInteractor
import com.example.workshopapp.domain.login.LoginResult
import com.example.workshopapp.domain.resource.IResourceProvider
import kotlinx.coroutines.launch

class Workshop2ViewModel(
    private val interactor: LoginInteractor,
    private val resourceProvider:IResourceProvider,
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    private val _userNameError = MutableLiveData<String>()
    private val _passwordError = MutableLiveData<String>()
    private val _success = MutableLiveData<Unit>()

    val loading: LiveData<Boolean> get() = _loading
    val userNameError: LiveData<String> get() = _userNameError
    val passwordError: LiveData<String> get() = _passwordError
    val success: LiveData<Unit> get() = _success

    fun login(userName: String, password: String) {
        viewModelScope.launch {
            //TODO 10: show progress via set true to _loading livedata

            val loginResult = interactor.login(userName = userName, password = password)

            //TODO 11: Handle "loginResult" with "when()".
            // In case of LoginResult.Error.UserName get string("user_name_error") via provider and set to _userNameError livedata
            // In case of LoginResult.Error.Password get string("password_error") via provider and set to _passwordError livedata
            // In case of LoginResult.Success set to _success livedata Unit


            //TODO 12: hide progress via set false to _loading livedata
        }
    }
}