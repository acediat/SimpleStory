package ru.acediat.engine.common

import kotlin.reflect.KClass

interface AcLogger {

    fun info(tag: String, message: String)

    fun debug(tag: String, message: String)

    fun <T : Any> debug(clazz: KClass<T>, message: String)

    fun error(tag: String, message: String? = null, throwable: Throwable)
}