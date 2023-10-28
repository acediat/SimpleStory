package ru.acediat.simplestory


import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import ru.acediat.engine.ScreenHolder
import ru.acediat.engine.contol.ScreenInputListener
import ru.acediat.engine.display.Painter
import ru.acediat.engine.display.Screen
import ru.acediat.simplestory.control.AndroidScreenInputListener
import ru.acediat.simplestory.display.PainterImpl
import ru.acediat.simplestory.screens.DemoScreen


class MainActivity : AppCompatActivity(), ScreenHolder {

    private lateinit var gameRenderView: GameRenderView

    private lateinit var painter: Painter
    private lateinit var screenInputListener: AndroidScreenInputListener

    private lateinit var currentScreen: Screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val frameBuffer = Bitmap.createBitmap(
            windowManager.defaultDisplay.width,
            windowManager.defaultDisplay.height,
            Bitmap.Config.ARGB_8888,
        )

        painter = PainterImpl(frameBuffer)
        screenInputListener = AndroidScreenInputListener()
        currentScreen = DemoScreen(painter, screenInputListener)

        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        val frameBufferWidth = if (isLandscape) 555 else 270 //2220 : 1080;
        val frameBufferHeight = if (isLandscape) 270 else 555 //1080 : 2220;


        val scaleX = frameBufferWidth.toFloat() / windowManager.defaultDisplay.width
        val scaleY = frameBufferHeight.toFloat() / windowManager.defaultDisplay.height

        gameRenderView = GameRenderView(this, this, frameBuffer).apply {
            setOnTouchListener(screenInputListener)
        }
        setContentView(gameRenderView)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    override fun onResume() {
        super.onResume()
        gameRenderView.resume()
    }

    override fun onStop() {
        super.onStop()
        gameRenderView.stop()
    }

    override fun getCurrentScreen(): Screen = currentScreen

    override fun setCurrentScreen(screen: Screen) {}
}