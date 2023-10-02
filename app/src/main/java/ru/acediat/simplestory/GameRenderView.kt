package ru.acediat.simplestory

import android.content.Context
import android.view.SurfaceView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.acediat.engine.ScreenHolder

class GameRenderView(
    context: Context,
    private val screenHolder: ScreenHolder,
) : SurfaceView(context) {

    private var running = false

    private val scope = CoroutineScope(Dispatchers.Default)

    fun resume() = scope.launch { render() }

    private fun render() {
        while(running) {
            if ()
        }
    }
}