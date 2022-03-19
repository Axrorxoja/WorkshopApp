package com.example.workshopapp.workshop3.solution

import androidx.annotation.StringRes
import com.example.workshopapp.R
import com.example.workshopapp.domain.login.LoginResult
import com.example.workshopapp.domain.resource.IResourceProvider
import com.example.workshopapp.workshop3.global.LoginViewState

class ReducerSolution(
    private val resourceProvider: IResourceProvider
) : (LoginViewState, LoginResult) -> LoginViewState {

    override fun invoke(
        oldState: LoginViewState,
        result: LoginResult,
    ): LoginViewState {
        return when (result) {
            LoginResult.Error.Password -> LoginViewState(passwordError = getString(R.string.password_error))
            LoginResult.Error.UserName -> LoginViewState(userNameError = getString(R.string.user_name_error))
            LoginResult.Success -> LoginViewState(success = true)
            LoginResult.Loading -> LoginViewState(isLoading = true)
        }
    }

    private fun getString(@StringRes id: Int) = resourceProvider.string(id)
}