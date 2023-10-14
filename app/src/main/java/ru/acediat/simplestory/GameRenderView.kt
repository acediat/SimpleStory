package ru.acediat.simplestory

import android.annotation.SuppressLint
import android.content.Context
import android.view.SurfaceView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.acediat.engine.ScreenHolder
import java.util.concurrent.atomic.AtomicBoolean

@SuppressLint("ViewConstructor")
class GameRenderView(
    context: Context,
    private val screenHolder: ScreenHolder,
) : SurfaceView(context) {

    private var running = AtomicBoolean(false)

    private val scope = CoroutineScope(Dispatchers.Default)
    private var renderJob: Job? = null

    fun resume() = scope.launch {
        render()
    }

    private fun render() {
        while(running.get()) {

        }
    }

    private fun stop() {
        running.compareAndSet(true, false)
        renderJob?.cancel()
        renderJob = null
    }
}