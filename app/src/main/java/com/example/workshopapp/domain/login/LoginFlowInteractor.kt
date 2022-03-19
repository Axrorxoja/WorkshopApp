package com.example.workshopapp.domain.login

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class LoginFlowInteractor {

    fun login(userName: String, password: String) = flow {
        emit(LoginResult.Loading)
        delay(DELAY_MILLIS)
        val result = when {
            userName.isEmpty() -> LoginResult.Error.UserName
            password.isEmpty() -> LoginResult.Error.Password
            else -> LoginResult.Success
        }
        emit(result)
    }

    companion object {
        const val DELAY_MILLIS: Long = 3_000
    }
}