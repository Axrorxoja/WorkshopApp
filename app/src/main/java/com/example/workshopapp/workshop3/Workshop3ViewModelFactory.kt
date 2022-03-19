package com.example.workshopapp.workshop3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.workshopapp.App
import com.example.workshopapp.domain.login.LoginFlowInteractor
import com.example.workshopapp.workshop3.solution.Workshop3SolutionViewModel

class Workshop3ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        Workshop3ViewModel::class.java -> Workshop3ViewModel(
            interactor = LoginFlowInteractor(),
            reducer = Reducer(
                resourceProvider = App.resourceProvider,
            ),
        )
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}