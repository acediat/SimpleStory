package ru.acediat.engine.contol

import ru.acediat.engine.shapes.AcPoint

sealed class ScreenInputEvent(x: Float, y: Float) {

    val point = AcPoint(x, y)

    class Down(x: Float, y: Float): ScreenInputEvent(x, y)
    class Up(x: Float, y: Float): ScreenInputEvent(x, y)
    class Hold(x: Float, y: Float): ScreenInputEvent(x, y)
    object None: ScreenInputEvent(-1.0f, -1.0f)
}