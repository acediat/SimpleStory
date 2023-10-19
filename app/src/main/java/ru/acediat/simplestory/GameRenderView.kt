package ru.acediat.simplestory

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
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
    private val frameBuffer: Bitmap,
) : SurfaceView(context) {

    private var running = AtomicBoolean(false)

    private val scope = CoroutineScope(Dispatchers.Default)
    private var renderJob: Job? = null

    fun resume() = scope.launch {
        running.compareAndSet(false, true)
        render()
    }

    fun stop() {
        running.compareAndSet(true, false)
        renderJob?.cancel()
        renderJob = null
    }

    private fun render() {
        while(running.get()) {
            if (!holder.surface.isValid){
                continue
            }
            screenHolder.getCurrentScreen().update(0.0)
            screenHolder.getCurrentScreen().present(0.0)
            with(holder.lockCanvas()) {
                val destinationRect = Rect()
                getClipBounds(destinationRect)
                drawBitmap(frameBuffer, null, destinationRect, null)
                holder.unlockCanvasAndPost(this)
            }
        }
    }
}