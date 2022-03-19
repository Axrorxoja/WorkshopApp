package com.example.workshopapp.workshop3

import androidx.annotation.StringRes
import com.example.workshopapp.R
import com.example.workshopapp.domain.login.LoginResult
import com.example.workshopapp.domain.resource.IResourceProvider
import com.example.workshopapp.workshop3.global.LoginViewState

class Reducer(
    private val resourceProvider: IResourceProvider
) : (LoginViewState, LoginResult) -> LoginViewState {

    override fun invoke(
        oldState: LoginViewState,
        loginResult: LoginResult,
    ): LoginViewState {
        //TODO 03: Handle "loginResult" with "when()".
        // In case of LoginResult.Error.Loading create "LoginViewState" with loading true
        // In case of LoginResult.Error.UserName get proper res id via provider and create "LoginViewState" with userNameError
        // In case of LoginResult.Error.Password get proper string id via provider and create "LoginViewState" with passwordError
        // In case of LoginResult.Success create "LoginViewState" with success true
        TODO()
    }

    private fun getString(@StringRes id: Int) = resourceProvider.string(id)
}