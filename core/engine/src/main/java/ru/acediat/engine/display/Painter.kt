package ru.acediat.engine.display

import ru.acediat.engine.shapes.AcRect

interface Painter {

    fun drawFilledRect(rect: AcRect, color: Int)
}