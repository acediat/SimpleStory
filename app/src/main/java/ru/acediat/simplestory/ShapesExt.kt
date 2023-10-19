package ru.acediat.simplestory

import android.graphics.Rect
import ru.acediat.engine.shapes.AcRect

fun fromAcRect(rect: AcRect): Rect = Rect(rect.left, rect.top, rect.right, rect.bottom)