package ru.acediat.simplestory.common

import android.util.Log
import ru.acediat.engine.common.AcLogger
import ru.acediat.engine.common.Config
import kotlin.reflect.KClass

object AcLoggerImpl : AcLogger {

    override fun info(tag: String, message: String) {
        Log.i(tag, message)
    }

    override fun debug(tag: String, message: String) {
        //if (Config.buildConfig.logsEnabled) {
            Log.d(tag, message)
        //}
    }

    override fun <T: Any> debug(clazz: KClass<T>, message: String) {
        //if (Config.buildConfig.logsEnabled) {
            Log.d(clazz.simpleName, message)
        //}
    }

    override fun error(tag: String, message: String?, throwable: Throwable) {
        Log.e(tag, message, throwable)
    }
}