package com.example.workshopapp.domain

import com.example.workshopapp.workshop3.global.LoginViewState
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import junit.framework.Assert.assertTrue


fun LoginViewState.assertIsDefault() {
    assertTrue(isDefault)
    assertFalse(isLoading)
    assertNull(userNameError)
    assertNull(passwordError)
    assertFalse(success)
}

fun LoginViewState.assertIsLoading() {
    assertFalse(isDefault)
    assertTrue(isLoading)
    assertNull(userNameError)
    assertNull(passwordError)
    assertFalse(success)
}

fun LoginViewState.assertIsUserNameError() {
    assertFalse(isDefault)
    assertFalse(isLoading)
    assertNotNull(userNameError)
    assertNull(passwordError)
    assertFalse(success)
}

fun LoginViewState.assertIsPasswordError() {
    assertFalse(isDefault)
    assertFalse(isLoading)
    assertNull(userNameError)
    assertNotNull(passwordError)
    assertFalse(success)
}

fun LoginViewState.assertIsSuccess() {
    assertFalse(isDefault)
    assertFalse(isLoading)
    assertNull(userNameError)
    assertNull(passwordError)
    assertTrue(success)
}



