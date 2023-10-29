package ru.acediat.simplestory

import android.graphics.Rect
import ru.acediat.engine.shapes.AcRect

fun fromAcRect(rect: AcRect): Rect = Rect(
    rect.left.toInt(),
    rect.top.toInt(),
    rect.right.toInt(),
    rect.bottom.toInt()
)