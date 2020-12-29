package com.example.project_4a_kadioglu.presentation.main

import android.provider.ContactsContract

sealed class LoginStatus {

    data class LoginSuccess(val email: String, val password: String) : LoginStatus()
    data class CreateSuccess(val email: String, val password: String) : LoginStatus()
    object  LoginError : LoginStatus()
    object  CreateError : LoginStatus()

}