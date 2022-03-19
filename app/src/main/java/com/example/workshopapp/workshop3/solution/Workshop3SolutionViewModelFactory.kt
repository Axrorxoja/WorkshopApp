package com.example.workshopapp.workshop3.solution

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.workshopapp.App
import com.example.workshopapp.domain.login.LoginFlowInteractor

class Workshop3SolutionViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        Workshop3SolutionViewModel::class.java -> Workshop3SolutionViewModel(
            interactor = LoginFlowInteractor(),
            reducer = ReducerSolution(
                resourceProvider = App.resourceProvider,
            ),
        )
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}