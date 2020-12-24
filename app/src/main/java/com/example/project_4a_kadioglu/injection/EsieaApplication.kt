package com.example.project_4a_kadioglu.injection

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext


class EsieaApplication : Application()
{
    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@EsieaApplication)
            modules(presentationModule, domainModule ,dataModule)
        }
    }
}