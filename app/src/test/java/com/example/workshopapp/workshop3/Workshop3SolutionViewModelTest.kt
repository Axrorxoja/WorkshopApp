package com.example.workshopapp.workshop3

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.workshopapp.domain.login.LoginFlowInteractor
import com.example.workshopapp.domain.login.LoginResult
import com.example.workshopapp.workshop3.global.LoginIntent
import com.example.workshopapp.workshop3.solution.ReducerSolution
import com.example.workshopapp.workshop3.solution.Workshop3SolutionViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class Workshop3SolutionViewModelTest {

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
    fun `when Login intent dispatched should called interactor and reducer`() = runBlockingTest {
        val mockInteractor = mock<LoginFlowInteractor>{
            on { this.login(any(), any()) } doReturn flowOf(LoginResult.Loading)
        }

        val mockReducer = mock<ReducerSolution>()
        val testUserName = "some userName"
        val testPassword = "some password"

        val viewModel = Workshop3SolutionViewModel(
            interactor = mockInteractor,
            reducer = mockReducer
        )

        viewModel.dispatchIntent(
            LoginIntent.Login(
                userName = testUserName,
                password = testPassword,
            )
        )

        verify(mockInteractor).login(
            userName = testUserName,
            password = testPassword,
        )
        verify(mockReducer).invoke(
            oldState = any(),
            result = any()
        )
    }
}