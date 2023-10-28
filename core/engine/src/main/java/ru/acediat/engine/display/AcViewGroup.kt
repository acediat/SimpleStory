package ru.acediat.engine.display

import ru.acediat.engine.contol.ScreenInputEvent

abstract class AcViewGroup : AcView() {

    protected val views = mutableListOf<AcView>()

    override fun handleEvent(event: ScreenInputEvent): Boolean {
        if (!inViewBounds(event.point)) {
            return false
        }
        super.handleEvent(event)
        views.forEach { it.handleEvent(event) }
        return true
    }
}