package ru.acediat.engine

import ru.acediat.engine.display.Screen

interface ScreenHolder {

    fun getCurrentScreen(): Screen

    fun setCurrentScreen(screen: Screen)
}