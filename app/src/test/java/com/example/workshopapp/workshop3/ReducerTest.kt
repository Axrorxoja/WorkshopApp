package com.example.workshopapp.workshop3

import com.example.workshopapp.domain.MockResourceProvider
import com.example.workshopapp.domain.assertIsLoading
import com.example.workshopapp.domain.assertIsPasswordError
import com.example.workshopapp.domain.assertIsSuccess
import com.example.workshopapp.domain.assertIsUserNameError
import com.example.workshopapp.domain.login.LoginResult
import com.example.workshopapp.workshop3.global.LoginViewState
import org.junit.Test

class ReducerTest {
    private val mockResourceProvider = MockResourceProvider()

    @Test
    fun `when loginResult Loading should reduce loading state`() {
        val reducer = createReducer()
        val oldState = LoginViewState(isDefault = true)

        val newState = reducer(oldState,LoginResult.Loading)
        //TODO 10: un comment code to check "newState" is loading
//        newState.assertIsLoading()
    }

    @Test
    fun `when loginResult error username should reduce userName state`() {
        val reducer = createReducer()
        val oldState = LoginViewState(isDefault = true)

        val newState = reducer(oldState,LoginResult.Error.UserName)
        //TODO 11: check with proper extension method which "newState" is "userNameError"
    }

    @Test
    fun `when loginResult error password should reduce password state`() {
        val reducer = createReducer()
        val oldState = LoginViewState(isDefault = true)

        val newState = reducer(oldState,LoginResult.Error.Password)
        //TODO 11: check with proper extension method which "newState" is "passwordError"
    }

    @Test
    fun `when loginResult success should reduce success state`() {
        val reducer = createReducer()
        val oldState = LoginViewState(isDefault = true)

        val newState = reducer(oldState,LoginResult.Success)
        //TODO 11: check with proper extension method which "newState" is "success"
    }

    private fun createReducer() = Reducer(mockResourceProvider)
}