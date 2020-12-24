package com.example.project_4a_kadioglu.presentation.main


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_4a_kadioglu.domain.entity.User
import com.example.project_4a_kadioglu.domain.usecase.CreateUserUseCase
import com.example.project_4a_kadioglu.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModule(
    private val createUserUseCase: CreateUserUseCase,
        private val getUserUseCase: GetUserUseCase): ViewModel()
{
    val counter: MutableLiveData<Int> = MutableLiveData()

    init
    {
        counter.value = 0
    }

    fun onClickedIncrement(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO){
            createUserUseCase.invoke(User("test"))
          val user =  getUserUseCase.invoke("test")
            val debug = "debug"

        }
    }
}