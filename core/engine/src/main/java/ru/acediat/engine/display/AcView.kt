package ru.acediat.engine.display

import ru.acediat.engine.common.AcLogger
import ru.acediat.engine.contol.ScreenInputEvent
import ru.acediat.engine.contol.ScreenInputHandler
import ru.acediat.engine.shapes.AcPoint
import ru.acediat.engine.shapes.Shape

abstract class AcView : ScreenInputHandler {

    protected abstract val bounds: Shape

    protected var logger: AcLogger? = null

    private val drawStack = ArrayDeque<() -> Unit>()

    private var onClick: (() -> Unit)? = null
    private var onTouch: ((ScreenInputEvent) -> Unit)? = null
    private var onHold: (() -> Unit)? = null

    fun registerLogger(logger: AcLogger) {
        this.logger = logger
    }

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
        logger?.debug(this::class, "Screen input event: $event")
        when(event) {
            is ScreenInputEvent.Up -> click()
            is ScreenInputEvent.Down -> touch(event)
            is ScreenInputEvent.Hold -> hold()
            is ScreenInputEvent.None -> {}
        }
        return true
    }

    protected fun putToDrawStack(operation: () -> Unit) {
        drawStack.addLast(operation)
    }

    protected fun invokeAllFromDrawStack() {
        while(!drawStack.isEmpty()) {
            drawStack.removeLast().invoke()
        }
    }

    protected open fun click() {
        onClick?.invoke()
    }

    protected open fun touch(event: ScreenInputEvent) {
        logger?.debug(this::class, "onTouch")
        onTouch?.invoke(event)
    }

    protected open fun hold() {
        onHold?.invoke()
    }

    protected fun inViewBounds(point: AcPoint) = bounds.contains(point)
}