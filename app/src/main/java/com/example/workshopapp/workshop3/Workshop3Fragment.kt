package com.example.workshopapp.workshop3

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.workshopapp.R
import com.example.workshopapp.workshop3.global.LoginViewState

class Workshop3Fragment : Fragment(R.layout.fragment_login) {

    private val viewModel: Workshop3ViewModel by viewModels { Workshop3ViewModelFactory() }

    private var userNameInput: EditText? = null
    private var passwordInput: EditText? = null
    private var loginBtn: View? = null
    private var loader: View? = null
    private var loginSuccess: View? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setUpListeners()

        // TODO 1: Subscribe on public LiveData with "Workshop2ViewModel.State" from viewModel.
        //  Use observe() method of LiveData.
        //  Pass "this.viewLifecycleOwner" as LifecycleOwner
        //  and { ... } lambda as lifecycle.Observer in parameters.
        //  Update UI with "renderState()" method from inside the lambda.
    }

    override fun onDestroyView() {
        userNameInput = null
        passwordInput = null
        loginBtn = null
        loader = null
        loginSuccess = null

        super.onDestroyView()
    }

    private fun renderState(state: LoginViewState) =
        when {
            state.isDefault -> {
                setLoading(loading = false)
            }
            state.isLoading -> {
                setLoading(loading = true)
            }
            state.userNameError != null -> {
                setLoading(loading = false)
                showUserNameError(state.userNameError)
            }
            state.passwordError != null -> {
                setLoading(loading = false)
                showPasswordError(state.passwordError)
            }
            state.success -> {
                setLoading(loading = false)
                showSuccess()
            }
            else -> {
                // TODO(Implemented new state detected)
            }
        }

    private fun setLoading(loading: Boolean) {
        loginBtn?.isEnabled = !loading
        loader?.isVisible = loading
    }

    private fun showUserNameError(userNameError: String) {
        userNameInput?.error = userNameError
    }

    private fun showPasswordError(passwordError: String) {
        passwordInput?.error = passwordError
    }

    private fun showSuccess() {
        loginBtn?.isVisible = false
        loginSuccess?.isVisible = true
    }

    private fun initViews(view: View) {
        userNameInput = view.findViewById(R.id.fragment_login_user_name_input)
        passwordInput = view.findViewById(R.id.fragment_login_password_input)
        loginBtn = view.findViewById(R.id.fragment_login_login_btn)
        loader = view.findViewById(R.id.fragment_login_loader)
        loginSuccess = view.findViewById(R.id.fragment_login_success)
    }

    private fun setUpListeners() {
        loginBtn?.setOnClickListener {
            tryToLogin()
        }
    }

    private fun tryToLogin() {
        val inputUserName = userNameInput?.text?.toString().orEmpty()
        val inputPassword = passwordInput?.text?.toString().orEmpty()

        //TODO 02: Create LoginIntent.Login() instance
        // with "inputUserName", "inputPassword"
        // and pass viewModel's "dispatchIntent()" method
    }

    companion object {
        fun newInstance(): Workshop3Fragment = Workshop3Fragment()
    }
}