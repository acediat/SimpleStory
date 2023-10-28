package ru.acediat.engine.contol

import java.util.Deque

interface ScreenInputListener {

    val events: Deque<ScreenInputEvent>
}