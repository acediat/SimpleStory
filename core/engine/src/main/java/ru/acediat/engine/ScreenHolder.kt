package ru.acediat.engine

interface ScreenHolder {

    fun getCurrentScreen(): Screen

    fun setCurrentScreen(screen: Screen)
}