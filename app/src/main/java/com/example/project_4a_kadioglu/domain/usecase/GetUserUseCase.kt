package com.example.project_4a_kadioglu.domain.usecase

import com.example.project_4a_kadioglu.data.repository.UserRepository
import com.example.project_4a_kadioglu.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository) {
    fun invoke(email: String, password: String): User?
    {
        return userRepository.getUser(email,password)
    }
}