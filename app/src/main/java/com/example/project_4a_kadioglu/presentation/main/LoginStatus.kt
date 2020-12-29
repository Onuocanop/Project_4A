package com.example.project_4a_kadioglu.presentation.main

import android.provider.ContactsContract

sealed class LoginStatus {

    data class LoginSuccess(val email: String) : LoginStatus()
    object  LoginError : LoginStatus()

}