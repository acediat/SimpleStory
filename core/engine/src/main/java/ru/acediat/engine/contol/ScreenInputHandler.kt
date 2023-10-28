package ru.acediat.engine.contol

interface ScreenInputHandler {

    fun handleEvent(event: ScreenInputEvent): Boolean
}