package com.darkoverlordofdata.shmupwarz.systems

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{SpriteBatch, TextureRegion, BitmapFont}
import com.darkoverlordofdata.entitas.{Matcher, IExecuteSystem, Pool}
import com.darkoverlordofdata.shmupwarz.GameScene
import com.darkoverlordofdata.shmupwarz.EntityExtensions._
import com.darkoverlordofdata.shmupwarz.Match


class ScoreRenderSystem (val game:GameScene, val pool:Pool) extends IExecuteSystem {

  lazy val group = pool.getGroup(Matcher.allOf(Match.Player, Match.Score))
  val width = game.width
  val height = game.height
  val desktop = game.desktop
  val scale = game.scale
  val pixelFactor:Int = { if (Gdx.graphics.getDensity > 1f) 2 else 1 }
  // val pixelFactor = game.pixelFactor
  val camera = game.camera
  lazy val batch = new SpriteBatch()
  lazy val font = CreateFont("fonts/hud")


  override def execute(): Unit = {
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    val player = group.singleEntity
    if (player != null) {
      if (desktop) {
        font.draw(batch, s"${player.score.value}", width/(2f*scale), (height/scale)-10f)
      } else {
        font.draw(batch, s"${player.score.value}", width/(2f*pixelFactor), (height/pixelFactor)-10f)
      }
    }
    batch.end()
  }

  def CreateFont(file: String): BitmapFont = {
    val fontTexture = new Texture(Gdx.files.internal(s"${file}_0.png"))
    fontTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.MipMapLinearLinear)
    val fontRegion = new TextureRegion(fontTexture)
    val font = new BitmapFont(Gdx.files.internal(s"${file}.fnt"), fontRegion, false)
    font.setUseIntegerPositions(false)
    font
  }
}
