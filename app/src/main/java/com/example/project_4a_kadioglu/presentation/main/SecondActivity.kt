package com.example.project_4a_kadioglu.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.project_4a_kadioglu.R
import com.example.project_4a_kadioglu.domain.usecase.CreateUserUseCase
import kotlinx.android.synthetic.main.activity_second.*
import com.example.project_4a_kadioglu.domain.usecase.GetUserUseCase
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.password_edit
import org.koin.android.ext.android.inject


class SecondActivity : AppCompatActivity() {
    private val secondActivity: MainViewModule by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        create_button.setOnClickListener {
            secondActivity.onClickCreateButton(
                user_edit.text.toString(),
                password_edit.text.toString()
            )



            secondActivity.loginLiveData.observe(this, Observer {
                when (it) {
                    is LoginStatus.CreateSuccess -> MaterialAlertDialogBuilder(this)
                        .setTitle("Successful")
                        .setMessage("Your account has been created")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()

                    LoginStatus.CreateError -> MaterialAlertDialogBuilder(this)
                        .setTitle("Oopsie Doopsie")
                        .setMessage("This username has already been taken or you have entered a non valid username/password")
                        .setPositiveButton("OK"){  dialog, which ->  dialog.dismiss()
                        }
                        .show()
                }
            })

        }
    }
}

