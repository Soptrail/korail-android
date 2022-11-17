package com.sopt.seminar9.korail.presentation.application

import android.app.Application
import com.sopt.seminar9.korail.presentation.application.container.AppContainer
import timber.log.Timber

class KorailApplication: Application() {
    val appContainer = AppContainer()

    init {
        application = this
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var application: Application
    }
}