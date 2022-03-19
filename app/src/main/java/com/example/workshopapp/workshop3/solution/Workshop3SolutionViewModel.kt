package com.example.workshopapp.workshop3.solution

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workshopapp.domain.login.LoginFlowInteractor
import com.example.workshopapp.domain.login.LoginResult
import com.example.workshopapp.workshop3.global.LoginIntent
import com.example.workshopapp.workshop3.global.LoginViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class Workshop3SolutionViewModel(
    private val interactor: LoginFlowInteractor,
    private val reducer: (LoginViewState, LoginResult) -> LoginViewState,
) : ViewModel() {

    private val _mutableState = MutableLiveData(LoginViewState(isDefault = true))

    val state: LiveData<LoginViewState> get() = _mutableState

    fun dispatchIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.Login -> login(intent.userName, intent.password)
            LoginIntent.CreateAccount -> TODO()
            LoginIntent.ForgotPassword -> TODO()
        }
    }

    private fun login(userName: String, password: String) {
        viewModelScope.launch {
            interactor.login(userName = userName, password = password)
                .map { reducer(_mutableState.value!!, it) }
                .collect(_mutableState::postValue)
        }
    }
}