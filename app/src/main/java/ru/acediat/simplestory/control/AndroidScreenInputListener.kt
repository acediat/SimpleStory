package ru.acediat.simplestory.control

import android.view.MotionEvent
import android.view.View
import ru.acediat.engine.contol.ScreenInputEvent
import ru.acediat.engine.contol.ScreenInputListener
import java.util.ArrayDeque
import java.util.Deque

class AndroidScreenInputListener : View.OnTouchListener, ScreenInputListener {

    override val events: Deque<ScreenInputEvent> = ArrayDeque()

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        with(event) {
            events.addLast(when (event.action and MotionEvent.ACTION_MASK) {
                MotionEvent.ACTION_DOWN,
                MotionEvent.ACTION_POINTER_DOWN -> ScreenInputEvent.Down(x, y)

                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_POINTER_UP,
                MotionEvent.ACTION_CANCEL -> ScreenInputEvent.Up(x, y)

                MotionEvent.ACTION_MOVE -> ScreenInputEvent.Hold(x, y)

                else -> ScreenInputEvent.None
            })
        }
        return true
    }
}