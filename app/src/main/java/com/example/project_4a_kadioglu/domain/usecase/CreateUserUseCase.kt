package com.example.project_4a_kadioglu.domain.usecase

import com.example.project_4a_kadioglu.data.repository.UserRepository
import com.example.project_4a_kadioglu.domain.entity.User

class CreateUserUseCase(private val userRepository: UserRepository)
{
    suspend fun invoke(user: User)
    {
        userRepository.createUser(user)
    }
}