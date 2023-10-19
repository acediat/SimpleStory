package ru.acediat.engine.display

abstract class Screen(
    protected val painter: Painter,
) {

    abstract fun update(deltaTime: Double)

    abstract fun present(deltaTime: Double)
}