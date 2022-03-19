package com.example.workshopapp.workshop3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workshopapp.domain.login.LoginInteractor
import com.example.workshopapp.domain.resource.IResourceProvider
import com.example.workshopapp.domain.resource.ResourceProvider
import kotlinx.coroutines.launch

class Workshop3ViewModel(
    private val interactor: LoginInteractor,
    private val resourceProvider: IResourceProvider,
) : ViewModel() {

    //TODO 06: Create private property MutableLiveData for state storing.
    // Pass initial value "State.Default" in constructor: MutableLiveData(State.Default()).

    //TODO 07: Create public property LiveData as a getter to provide state outside.
    // Init this public getter with your private MutableLiveData.

    fun login(userName: String, password: String) {
        viewModelScope.launch {
            //TODO 08: Set "State.Loading()" to the private liveData's value.

            val loginResult = interactor.login(userName = userName, password = password)

            //TODO 09: Handle "loginResult" with "when()".
            // Set actual "State. ...()" to the private liveData's value (success, errors).
        }
    }

    sealed class State {
        class Default : State()
        class Loading : State()
        class UserNameError : State()
        class PasswordError : State()
        class Success : State()
    }
}