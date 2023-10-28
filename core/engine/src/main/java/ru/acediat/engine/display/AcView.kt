package ru.acediat.engine.display

import ru.acediat.engine.contol.ScreenInputEvent
import ru.acediat.engine.contol.ScreenInputHandler
import ru.acediat.engine.shapes.AcPoint
import ru.acediat.engine.shapes.Shape

abstract class AcView : ScreenInputHandler {

    private var onClick: (() -> Unit)? = null
    private var onTouch: ((ScreenInputEvent) -> Unit)? = null
    private var onHold: (() -> Unit)? = null

    protected abstract val bounds: Shape

    fun setOnClickListener(onClick: () -> Unit) {
        this.onClick = onClick
    }

    fun setOnTouchListener(onTouch: (ScreenInputEvent) -> Unit) {
        this.onTouch = onTouch
    }

    fun setOnHoldListener(onHold: () -> Unit) {
        this.onHold = onHold
    }

    override fun handleEvent(event: ScreenInputEvent): Boolean {
        if (!inViewBounds(event.point)) {
            return false
        }
        when(event) {
            is ScreenInputEvent.Up -> click()
            is ScreenInputEvent.Down -> touch(event)
            is ScreenInputEvent.Hold -> hold()
            is ScreenInputEvent.None -> {}
        }
        return true
    }

    protected open fun click() {
        onClick?.invoke()
    }

    protected open fun touch(event: ScreenInputEvent) {
        onTouch?.invoke(event)
    }

    protected open fun hold() {
        onHold?.invoke()
    }

    protected fun inViewBounds(point: AcPoint) = bounds.contains(point)
}