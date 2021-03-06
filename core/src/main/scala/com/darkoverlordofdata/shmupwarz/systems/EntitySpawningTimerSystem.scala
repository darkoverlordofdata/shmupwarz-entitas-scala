package com.darkoverlordofdata.shmupwarz.systems

import com.badlogic.gdx.Gdx
import com.darkoverlordofdata.shmupwarz.GameScene
import com.darkoverlordofdata.entitas.{IExecuteSystem, Pool}
import com.darkoverlordofdata.shmupwarz.Factory._

class EntitySpawningTimerSystem (val game:GameScene, val pool:Pool) extends IExecuteSystem {

  private val Timer1 = 2f
  private val Timer2 = 6f
  private val Timer3 = 12f
  private var t1 = Timer1
  private var t2 = Timer2
  private var t3 = Timer3
  val desktop = game.desktop

  // def toWorldX:Float = if (desktop) 525f/game.width else 350f/game.width
  // def toWorldY:Float = if (desktop) 360f/game.height else 480f/game.height
  // def width:Float = game.width*toWorldX
  // def height:Float = game.height*toWorldY

  def width:Float = Gdx.graphics.getWidth.toFloat
  def height:Float = Gdx.graphics.getHeight.toFloat

  object Enemies {
    sealed trait EnumVal
    case object Enemy1 extends EnumVal
    case object Enemy2 extends EnumVal
    case object Enemy3 extends EnumVal
    val enemyType = Seq(Enemy1, Enemy2, Enemy3)
  }

  def spawnEnemy(delta: Float, t:Float, enemy: Enemies.EnumVal): Float = {
    val remaining = t - Gdx.graphics.getDeltaTime
    if (remaining < 0) {
      enemy match {
        case Enemies.Enemy1 => {
          pool.createEnemy1(game, width, height)
          Timer1
        }
        case Enemies.Enemy2 => {
          pool.createEnemy2(game, width, height)
          Timer2
        }
        case Enemies.Enemy3 => {
          pool.createEnemy3(game, width, height)
          Timer3
        }
      }
    } else remaining
  }

  override def execute(): Unit = {
    val delta = Gdx.graphics.getDeltaTime
    t1 = spawnEnemy(delta, t1, Enemies.Enemy1)
    t2 = spawnEnemy(delta, t2, Enemies.Enemy2)
    t3 = spawnEnemy(delta, t3, Enemies.Enemy3)

  }
}
