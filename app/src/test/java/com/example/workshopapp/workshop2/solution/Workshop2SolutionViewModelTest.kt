package com.example.workshopapp.workshop2.solution

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.workshopapp.domain.ERROR_MESSAGE
import com.example.workshopapp.domain.MockResourceProvider
import com.example.workshopapp.domain.getOrAwaitValue
import com.example.workshopapp.domain.login.LoginInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class Workshop2ViewModelTest {

    private lateinit var testDispatcher: TestCoroutineDispatcher

    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        testDispatcher = TestCoroutineDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun cleanUp() {
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `assert login UserNameError`() = runBlockingTest {
        // Prepare all components for testing
        val viewModel = createComponents()

        viewModel.login(userName = "", password = "")

        // Checking the view
        viewModel.assert(
            expectedLoading = true,
            expectedUserNameError = null,
            expectedPasswordError = null,
            expectedSuccess = null
        )

        testDispatcher.advanceTimeBy(LoginInteractor.DELAY_MILLIS)

        // Checking the view after delay
        viewModel.assert(
            expectedLoading = false,
            expectedUserNameError = ERROR_MESSAGE,
            expectedPasswordError = null,
            expectedSuccess = null
        )
    }

    @Test
    fun `assert login PasswordError`() = runBlockingTest {
        val viewModel = createComponents()

        viewModel.login(userName = "amazing user name", password = "")

        viewModel.assert(
            expectedLoading = true,
            expectedUserNameError = null,
            expectedPasswordError = null,
            expectedSuccess = null
        )

        testDispatcher.advanceTimeBy(LoginInteractor.DELAY_MILLIS)
        viewModel.assert(
            expectedLoading = false,
            expectedUserNameError = null,
            expectedPasswordError = ERROR_MESSAGE,
            expectedSuccess = null
        )
    }

    @Test
    fun `assert login Success`() = runBlockingTest {
        val viewModel = createComponents()

        viewModel.login(userName = "amazing user name", password = "amazing password")

        viewModel.assert(
            expectedLoading = true,
            expectedUserNameError = null,
            expectedPasswordError = null,
            expectedSuccess = null
        )

        testDispatcher.advanceTimeBy(LoginInteractor.DELAY_MILLIS)
        viewModel.assert(
            expectedLoading = false,
            expectedUserNameError = null,
            expectedPasswordError = null,
            expectedSuccess = Unit
        )
    }

    private fun createComponents(): Workshop2SolutionViewModel {
        val interactor = LoginInteractor(dispatcher = testDispatcher)
        return Workshop2SolutionViewModel(interactor = interactor, resourceProvider = MockResourceProvider())
    }
}

private fun Workshop2SolutionViewModel.assert(
    expectedLoading: Boolean,
    expectedUserNameError: String?,
    expectedPasswordError: String?,
    expectedSuccess: Unit?
) {
    when {
        expectedLoading -> Assert.assertEquals(this.loading.getOrAwaitValue(), expectedLoading)
        expectedUserNameError != null -> Assert.assertEquals(this.userNameError.getOrAwaitValue(), expectedUserNameError)
        expectedPasswordError != null -> Assert.assertEquals(this.passwordError.getOrAwaitValue(), expectedPasswordError)
        expectedSuccess != null -> Assert.assertEquals(this.success.getOrAwaitValue(), expectedSuccess)
    }
}