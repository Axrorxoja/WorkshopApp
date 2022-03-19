package com.example.workshopapp.workshop3

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.workshopapp.R
import com.example.workshopapp.workshop3.global.Workshop3ViewModelFactory

class Workshop3Fragment : Fragment(R.layout.fragment_workshop_1) {

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

        // TODO 10: Subscribe on public LiveData with "Workshop2ViewModel.State" from viewModel.
        //  Use observe() method of LiveData.
        //  Pass "this.viewLifecycleOwner" as LifecycleOwner
        //  and { ... } lambda as lifecycle.Observer in parameters.
        //  Update UI with "setState()" method from inside the lambda.
    }

    override fun onDestroyView() {
        userNameInput = null
        passwordInput = null
        loginBtn = null
        loader = null
        loginSuccess = null

        super.onDestroyView()
    }

    private fun setState(state: Workshop3ViewModel.State) =
        when (state) {
            is Workshop3ViewModel.State.Default -> {
                setLoading(loading = false)
            }
            is Workshop3ViewModel.State.Loading -> {
                setLoading(loading = true)
            }
            is Workshop3ViewModel.State.UserNameError -> {
                setLoading(loading = false)
                showUserNameError()
            }
            is Workshop3ViewModel.State.PasswordError -> {
                setLoading(loading = false)
                showPasswordError()
            }
            is Workshop3ViewModel.State.Success -> {
                setLoading(loading = false)
                showSuccess()
            }
        }

    private fun setLoading(loading: Boolean) {
        //TODO 01: Depending on "loading" value, set "loader" visibility = View.VISIBLE/GONE.
        // And opposite, set "loginBtn" disabled/enabled.
    }

    private fun showUserNameError() {
        //TODO 02: Set error for "userNameInput" from strings resources (ws01_ws02_user_name_error).
    }

    private fun showPasswordError() {
        //TODO 03: Set error for "passwordInput" from strings resources (ws01_ws02_password_error).
    }

    private fun showSuccess() {
        //TODO 04: Set "loginBtn" visibility = View.INVISIBLE.
        // And opposite, set "loginSuccess" visibility = View.VISIBLE.
    }

    private fun initViews(view: View) {
        userNameInput = view.findViewById(R.id.fragment_workshop_1_workshop_2_user_name_input)
        passwordInput = view.findViewById(R.id.fragment_workshop_1_workshop_2_password_input)
        loginBtn = view.findViewById(R.id.fragment_workshop_1_workshop_2_login_btn)
        loader = view.findViewById(R.id.fragment_workshop_1_workshop_2_loader)
        loginSuccess = view.findViewById(R.id.fragment_workshop_1_workshop_2_login_success)
    }

    private fun setUpListeners() {
        loginBtn?.setOnClickListener {
            tryToLogin()
        }
    }

    private fun tryToLogin() {
        val inputUserName = userNameInput?.text?.toString().orEmpty()
        val inputPassword = passwordInput?.text?.toString().orEmpty()

        //TODO 05: Call viewModel's "login()" method.
    }

    companion object {
        fun newInstance(): Workshop3Fragment = Workshop3Fragment()
    }
}