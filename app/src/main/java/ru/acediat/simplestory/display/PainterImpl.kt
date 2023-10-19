package ru.acediat.simplestory.display

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import ru.acediat.engine.display.Painter
import ru.acediat.engine.shapes.AcRect
import ru.acediat.simplestory.fromAcRect

class PainterImpl(
    frameBuffer: Bitmap,
) : Painter {

    private val canvas = Canvas(frameBuffer)
    private val paint = Paint()

    override fun drawFilledRect(rect: AcRect, color: Int) {
        paint.color = color
        paint.style = Paint.Style.FILL
        canvas.drawRect(fromAcRect(rect), paint)
    }
}