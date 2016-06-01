package com.darkoverlordofdata.demo

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.{Sprite, TextureAtlas}
import com.badlogic.gdx.utils.Json
import com.uwsoft.editor.renderer.data.CompositeItemVO
import com.uwsoft.editor.renderer.data.ProjectInfoVO
import com.uwsoft.editor.renderer.data.SceneVO

object Layer extends Enumeration {
  type Effect = Value
  var BULLET, BATTLE, PLAYER, ENEMY1, ENEMY2, ENEMY3 = Value
}

object Effect extends Enumeration {
  type Effect = Value
  var PEW, ASPLODE, SMALLASPLODE = Value
}


object O2dLibrary {

  val PROJECT = "project.dt"        /** Overlap2D Project data */
  val SCENE = "scenes/MainScene.dt" /** Overlap2D Scene data */
  val ATLAS = "orig/pack.atlas"     /** Overlap2D Packed atlas */


  lazy val project: ProjectInfoVO = {
    val file = Gdx.files.internal(PROJECT)
    val json = new Json()
    json.fromJson(classOf[ProjectInfoVO], file.readString())
  }

  lazy val scene: SceneVO = {
    val file = Gdx.files.internal(SCENE)
    val json = new Json()
    json.fromJson(classOf[SceneVO], file.readString())
  }

  lazy val sprites: TextureAtlas = {
    val packFile = Gdx.files.internal(ATLAS)
    new TextureAtlas(packFile)
  }

  def getItem(name:String):CompositeItemVO = {
    project.libraryItems.get(name)
  }

  def getResource(name:String):String = {
    getItem(name).composite.sImages.get(0).imageName
  }

  def getSprite(name:String):Sprite = {
    sprites.createSprite(getResource(name))
  }

  def getLayer(name:String):Int  = {
    Layer.withName(getItem(name).layerName.toUpperCase).id
  }

  def getSoundEffect(name:String):Int = {

    name match {
      case "bullet" => Effect.PEW.id
      case "bang" => Effect.SMALLASPLODE.id
      case "explosion" => Effect.ASPLODE.id
      case _ => -1
    }
  }
}
