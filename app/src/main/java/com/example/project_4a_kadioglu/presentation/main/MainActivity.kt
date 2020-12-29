package com.example.project_4a_kadioglu.presentation.main


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SectionIndexer
import androidx.lifecycle.Observer
import com.example.project_4a_kadioglu.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mainViewModule: MainViewModule by inject()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        create_account_button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        mainViewModule.loginLiveData.observe(this, Observer {
            when(it)
            {
                is LoginStatus.LoginSuccess -> {
                   // TODO() NAVIGATE
                }

                LoginStatus.LoginError -> MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Oopsies")
                        .setPositiveButton("OK"){  dialog, which ->  dialog.dismiss()
                        }
                        .show()
            }
        })

        login_button.setOnClickListener {
            mainViewModule.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }



    }





}