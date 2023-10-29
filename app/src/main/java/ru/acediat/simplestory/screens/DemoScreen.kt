package ru.acediat.simplestory.screens

import android.graphics.Color
import android.util.Log
import ru.acediat.engine.contol.ScreenInputListener
import ru.acediat.engine.display.Painter
import ru.acediat.engine.display.Screen
import ru.acediat.engine.shapes.AcRect
import ru.acediat.engine.shapes.Shape
import ru.acediat.simplestory.common.AcLoggerImpl

class DemoScreen(
    painter: Painter,
    screenInputListener: ScreenInputListener
) : Screen(painter, screenInputListener) {

    override val bounds: Shape
        get() = AcRect(0.0f,10000.0f,0.0f,10000.0f)


    init {
        registerLogger(AcLoggerImpl)
        setOnTouchListener {
            logger?.debug(this::class, "onTouch custom")
            putToDrawStack {
                painter.drawFilledRect(AcRect(it.point.x, it.point.x + 10.0f, it.point.y, it.point.y + 10), Color.GREEN)
            }
        }
    }

    override fun update(deltaTime: Double) {
        super.update(deltaTime)
    }

    override fun present(deltaTime: Double) {
        painter.drawFilledRect(bounds as AcRect, Color.BLUE)
        super.present(deltaTime)
    }
}