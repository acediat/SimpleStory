package ru.acediat.simplestory.screens

import android.graphics.Color
import ru.acediat.engine.display.Painter
import ru.acediat.engine.display.Screen
import ru.acediat.engine.shapes.AcRect

class DemoScreen(painter: Painter) : Screen(painter) {

    private var x = 0

    override fun update(deltaTime: Double) {
        x++
    }

    override fun present(deltaTime: Double) {
        painter.drawFilledRect(AcRect(100 + x,200 + x , 100, 200), Color.BLUE)
    }
}