package com.example.project_4a_kadioglu.presentation.main


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_4a_kadioglu.domain.entity.User
import com.example.project_4a_kadioglu.domain.usecase.CreateUserUseCase
import com.example.project_4a_kadioglu.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModule(
    private val createUserUseCase: CreateUserUseCase,
        private val getUserUseCase: GetUserUseCase): ViewModel()
{
    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()


    fun onClickedLogin(emailUser: String/*, password: String*/) {
        viewModelScope.launch(Dispatchers.IO){
        val user =    getUserUseCase.invoke(emailUser/*, password*/)
      //      createUserUseCase.invoke(User("test"))
       //   val user =  getUserUseCase.invoke("test")
      val loginStatus = if(user != null)
       {
           LoginStatus.LoginSuccess(user.email)
       }
        else{
          LoginStatus.LoginError
      }
            withContext(Dispatchers.Main)
            {
                loginLiveData.value = loginStatus
            }
        }
    }
}