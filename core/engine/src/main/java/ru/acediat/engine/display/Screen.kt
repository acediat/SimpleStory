package ru.acediat.engine.display

import ru.acediat.engine.contol.ScreenInputListener

abstract class Screen(
    protected val painter: Painter,
    protected val inputHandler: ScreenInputListener,
) : AcViewGroup() {

    open fun update(deltaTime: Double) {
        with(inputHandler.events) {
            while(!isEmpty()) {
                handleEvent(removeFirst())
            }
        }
    }

    abstract fun present(deltaTime: Double)

}