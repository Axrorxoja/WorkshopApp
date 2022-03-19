package com.example.workshopapp.workshop1

internal class Workshop1ViewMock : Workshop1View {

    var isLoading: Boolean = false
        private set

    var userNameErrorShownTimes: Int = 0
        private set

    var passwordErrorShownTimes: Int = 0
        private set

    var successShownTimes: Int = 0
        private set

    override fun setLoading(loading: Boolean) {
        isLoading = loading
    }

    override fun showUserNameError() {
        userNameErrorShownTimes++
    }

    override fun showPasswordError() {
        passwordErrorShownTimes++
    }

    override fun showSuccess() {
        successShownTimes++
    }
}