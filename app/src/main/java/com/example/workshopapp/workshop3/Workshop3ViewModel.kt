package com.example.workshopapp.workshop3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workshopapp.domain.login.LoginFlowInteractor
import com.example.workshopapp.domain.login.LoginResult
import com.example.workshopapp.workshop3.global.LoginIntent
import com.example.workshopapp.workshop3.global.LoginViewState
import kotlinx.coroutines.launch

class Workshop3ViewModel(
    private val interactor: LoginFlowInteractor,
    private val reducer: (LoginViewState, LoginResult) -> LoginViewState,
) : ViewModel() {

    //TODO 04: For state storing create private MutableLiveData with default value of LoginViewState default true.

    //TODO 05: Create public property LiveData as a getter to provide state outside.
    // Init this public getter with your private MutableLiveData.

    fun dispatchIntent(loginIntent: LoginIntent) {
        //TODO 06: Handle "loginIntent" with "when()"
        // and in "LoginIntent.Login" state call "login" method
        // others states could leave as {}
    }

    private fun login(userName: String, password: String) {
        viewModelScope.launch {
            //TODO 07: call "interactor.login"
            //TODO 08: map with reducer old state you can got from livedata.value!!
            //TODO 09: call collect and inside lambda set value to livedata
        }
    }
}