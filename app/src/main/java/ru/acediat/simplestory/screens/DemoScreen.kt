package ru.acediat.simplestory.screens

import android.graphics.Color
import ru.acediat.engine.contol.ScreenInputListener
import ru.acediat.engine.display.Painter
import ru.acediat.engine.display.Screen
import ru.acediat.engine.shapes.AcRect
import ru.acediat.engine.shapes.Shape

class DemoScreen(
    painter: Painter,
    screenInputListener: ScreenInputListener
) : Screen(painter, screenInputListener) {

    override val bounds: Shape
        get() = AcRect(10000.0f,10000.0f,10000.0f,10000.0f)

    private var x = 0

    init {
        setOnTouchListener {
            painter.drawFilledRect(AcRect(it.point.x, it.point.x + 10.0f, it.point.y, it.point.y + 10), Color.GREEN)
        }
    }

    override fun update(deltaTime: Double) {
        x++
    }

    override fun present(deltaTime: Double) {
        painter.drawFilledRect(AcRect(100.0f + x,200.0f + x , 100.0f, 200.0f), Color.BLUE)
    }
}