package com.example.workshopapp.workshop2.solution

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.workshopapp.R

class Workshop2SolutionFragment : Fragment(R.layout.fragment_workshop_1) {

    private val viewModel: Workshop2SolutionViewModel by viewModels { Workshop2SolutionViewModelFactory() }

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
        viewModel.loading.observe(viewLifecycleOwner,this::setLoading)
        viewModel.success.observe(viewLifecycleOwner,this::showSuccess)
        viewModel.userNameError.observe(viewLifecycleOwner,this::showUserNameError)
        viewModel.passwordError.observe(viewLifecycleOwner,this::showPasswordError)
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
        loginBtn?.isEnabled = !loading
        loader?.isVisible = loading
    }

    private fun showUserNameError(errorText: String) {
        userNameInput?.error = errorText
    }

    private fun showPasswordError(errorText: String) {
        passwordInput?.error = errorText
    }

    private fun showSuccess(unit:Unit) {
        loginBtn?.isVisible = false
        loginSuccess?.isVisible = true
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

        viewModel.login(userName = inputUserName, password = inputPassword)
    }

    companion object {
        fun newInstance(): Workshop2SolutionFragment = Workshop2SolutionFragment()
    }
}