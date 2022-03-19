package com.example.workshopapp.workshop2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.workshopapp.R
import com.example.workshopapp.workshop2.global.Workshop2ViewModelFactory
import com.example.workshopapp.workshop2.solution.Workshop2SolutionFragment

class Workshop2Fragment : Fragment(R.layout.fragment_workshop_1){

    private val viewModel: Workshop2ViewModel by viewModels { Workshop2ViewModelFactory() }

    private var userNameInput: EditText? = null
    private var passwordInput: EditText? = null
    private var loginBtn: View? = null
    private var loader: View? = null
    private var loginSuccess: View? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setUpListeners()
        listenViewModel()
    }

    private fun listenViewModel() {
        // TODO 06: Subscribe on public LiveData with "Workshop2ViewModel.loading" from viewModel
        //  and call "setLoading" method inside livedata observer.

        // TODO 07: Subscribe on public LiveData with "Workshop2ViewModel.success" from viewModel
        //  and call "showSuccess" method inside livedata observer.

        // TODO 08: Subscribe on public LiveData with "Workshop2ViewModel.userNameError" from viewModel
        //  and call "showUserNameError" method inside livedata observer.

        // TODO 09: Subscribe on public LiveData with "Workshop2ViewModel.passwordError" from viewModel
        //  and call "showPasswordError" method inside livedata observer.
    }

    override fun onDestroyView() {
        userNameInput = null
        passwordInput = null
        loginBtn = null
        loader = null
        loginSuccess = null

        super.onDestroyView()
    }

    private fun setLoading(loading: Boolean) {
        //TODO 01: Depending on "loading" value, set "loader" visibility = View.VISIBLE/GONE.
        // And opposite, set "loginBtn" disabled/enabled.
    }

    private fun showUserNameError(userNameError: String) {
        //TODO 02: Set "userNameError" for "userNameInput" as error.
    }

    private fun showPasswordError(passwordError: String) {
        //TODO 03: Set "passwordError" for "passwordInput" as error.
    }

    private fun showSuccess(unit:Unit) {
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
        fun newInstance(): Workshop2SolutionFragment = Workshop2SolutionFragment()
    }
}