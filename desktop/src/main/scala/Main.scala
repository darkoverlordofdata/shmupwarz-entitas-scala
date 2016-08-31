package main.scala

import com.badlogic.gdx.backends.lwjgl._
import com.darkoverlordofdata.shmupwarz.Shmupwarz

object Main extends App {
    val cfg = new LwjglApplicationConfiguration
    cfg.title = "ShmupWarz"
    cfg.height = 480
    cfg.width = 350
    cfg.forceExit = false
    new LwjglApplication(new Shmupwarz, cfg)
}
