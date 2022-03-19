package com.example.workshopapp.workshop3.solution

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workshopapp.R
import com.example.workshopapp.domain.login.LoginInteractor
import com.example.workshopapp.domain.login.LoginResult
import com.example.workshopapp.domain.resource.IResourceProvider
import kotlinx.coroutines.launch

class Workshop3SolutionViewModel(
    private val interactor: LoginInteractor,
    private val resourceProvider: IResourceProvider,
) : ViewModel() {

    private val _mutableState = MutableLiveData<LoginViewState>()

    val state: LiveData<LoginViewState> get() = _mutableState

    fun login(userName: String, password: String) {
        // TODO logging
        viewModelScope.launch {
            _mutableState.setValue(LoginViewState(isLoading = true))

            val loginResult = interactor.login(userName = userName, password = password)

            val newViewState = when (loginResult) {
                is LoginResult.Error.UserName -> LoginViewState(userNameError = getString(R.string.ws01_ws02_user_name_error))
                is LoginResult.Error.Password -> LoginViewState(userNameError = getString(R.string.ws01_ws02_password_error))
                is LoginResult.Success -> LoginViewState(success = true)
            }
            _mutableState.setValue(newViewState)
        }
    }

    private fun getString(@StringRes id:Int) = resourceProvider.string(id);
}