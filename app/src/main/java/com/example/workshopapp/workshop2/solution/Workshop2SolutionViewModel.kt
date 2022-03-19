package com.example.workshopapp.workshop2.solution

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workshopapp.R
import com.example.workshopapp.domain.login.LoginInteractor
import com.example.workshopapp.domain.login.LoginResult
import com.example.workshopapp.domain.resource.IResourceProvider
import kotlinx.coroutines.launch

class Workshop2SolutionViewModel(
    private val interactor: LoginInteractor,
    private val resourceProvider: IResourceProvider,
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
            _loading.postValue(true)

            val loginResult = interactor.login(userName = userName, password = password)

            when (loginResult) {
                is LoginResult.Error.UserName -> _userNameError.postValue(resourceProvider.string(R.string.ws01_ws02_user_name_error))
                is LoginResult.Error.Password -> _passwordError.postValue(resourceProvider.string(R.string.ws01_ws02_password_error))
                is LoginResult.Success -> _success.postValue(Unit)
            }
            _loading.postValue(false)
        }
    }
}