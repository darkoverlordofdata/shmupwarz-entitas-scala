package com.darkoverlordofdata.shmupwarz
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.FitViewport
import com.uwsoft.editor.renderer.SceneLoader
import com.uwsoft.editor.renderer.scene2d.CompositeActor

class MenuUI(game: Shmupwarz, sceneLoader: SceneLoader) extends Stage() {

  sceneLoader.loadScene("MenuScene", new FitViewport(350f, 480f))

  val playButtonVo = sceneLoader.loadVoFromLibrary("playButton")
  val playButtonActor = new CompositeActor(playButtonVo, sceneLoader.getRm)
  val desktop = game.desktop
  val scale = game.scale
  val pixelFactor = if (desktop) scale else if (Gdx.graphics.getDensity > 1f) 2f else 1f
  val col = (getWidth-playButtonActor.getWidth*pixelFactor)/2f
  val row = (pixelFactor-1f)*100f-200f*pixelFactor

  addActor(playButtonActor)
  playButtonActor.setX(col)
  playButtonActor.setY(row+220f*2f*pixelFactor)
  playButtonActor.setScale(pixelFactor)
  playButtonActor.addListener(new ClickListener() {
    override def clicked(event: InputEvent, x: Float, y: Float) {
      game.playGame()
    }
  })

  val scoreButtonVo  = sceneLoader.loadVoFromLibrary("scoreButton")
  val scoreButtonActor = new CompositeActor(scoreButtonVo, sceneLoader.getRm)
  addActor(scoreButtonActor)
  scoreButtonActor.setX(col)
  scoreButtonActor.setY(row+180f*2f*pixelFactor)
  scoreButtonActor.setScale(pixelFactor)
  scoreButtonActor.addListener(new ClickListener() {
    override def clicked(event: InputEvent, x: Float, y: Float) {
      game.scoreGame()
    }
  })

  val optionButtonVo  = sceneLoader.loadVoFromLibrary("optionButton")
  val optionButtonActor = new CompositeActor(optionButtonVo, sceneLoader.getRm)
  addActor(optionButtonActor)
  optionButtonActor.setX(col)
  optionButtonActor.setY(row+140f*2f*pixelFactor)
  optionButtonActor.setScale(pixelFactor)
  optionButtonActor.addListener(new ClickListener() {
    override def clicked(event: InputEvent, x: Float, y: Float) {
      game.optionsGame()
    }
  })

  Gdx.input.setInputProcessor(this)

}
