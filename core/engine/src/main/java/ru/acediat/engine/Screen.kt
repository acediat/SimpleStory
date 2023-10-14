package ru.acediat.engine

interface ScreenState

interface ScreenEvent

abstract class Screen {

    abstract fun update(deltaTime: Double)
}