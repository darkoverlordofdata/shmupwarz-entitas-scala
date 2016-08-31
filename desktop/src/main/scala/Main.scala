package main.scala

import com.badlogic.gdx.backends.lwjgl._
import com.darkoverlordofdata.shmupwarz.Shmupwarz

object Main extends App {
    val desktop = true
    val scale = 1.5f
    val width = 1050 //((if (desktop) 700 else 350)*scale).toInt
    val height = 720 //(480*scale).toInt

    val cfg = new LwjglApplicationConfiguration
    cfg.title = "ShmupWarz"
    cfg.height = height
    cfg.width = width
    cfg.forceExit = false
    new LwjglApplication(new Shmupwarz(desktop, scale), cfg)
}
