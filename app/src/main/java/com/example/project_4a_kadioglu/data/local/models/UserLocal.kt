package com.example.project_4a_kadioglu.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.project_4a_kadioglu.domain.entity.User

@Entity
data class UserLocal(@ColumnInfo(name = "email") val email: String,
                     @ColumnInfo(name = "password") val password: String
) {
    @PrimaryKey(autoGenerate = true) var uid: Int ?= null
}

fun User.toData(): UserLocal {
    return UserLocal(
    email = email,
    password = password)
}

fun UserLocal.toEntity(): User {
    return User(
        email = email,
    password = password)
}