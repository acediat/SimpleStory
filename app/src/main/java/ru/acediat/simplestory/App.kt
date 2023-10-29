package ru.acediat.simplestory

import android.app.Application
import ru.acediat.engine.common.BuildType
import ru.acediat.engine.common.Config

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Config.buildConfig = BuildType.DEBUG
        } else {
            Config.buildConfig = BuildType.RELEASE
        }
    }
}