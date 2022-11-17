package com.sopt.seminar9.korail

import android.app.Application
import timber.log.Timber

class KorailApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}