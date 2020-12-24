package com.example.project_4a_kadioglu.injection

import com.example.project_4a_kadioglu.MainViewModule
import org.koin.dsl.module

val  presentationModule = module {
    factory{
        MainViewModule()
    }
}