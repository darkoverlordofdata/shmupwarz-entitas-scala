# shmupwarz-entitas-scala

Using entitas & overlap2d

Added sbt for atom-ensime, based on ajhager/libgdx-sbt-project.g8

All artwork is from http://opengameart.org/ 

spaceships by http://millionthvector.blogspot.com/

Shmupwarz is inspired by https://github.com/Flet/spaceship-warrior-gradle,
which was created using the AtemisODB entity component system



    entitas init com.darkoverlordofdata.demo
    entitas create -c Bounds radius:Float
    entitas create -c Bullet
    entitas create -c Destroy
    entitas create -c Enemy
    entitas create -c Expires delay:Float
    entitas create -c Firing
    entitas create -c Health currentHealth:Float maximumHealth:Float
    entitas create -c Layer ordinal:Int
    entitas create -c Player
    entitas create -c Position x:Float y:Float
    entitas create -c Resource name:String
    entitas create -c Scale x:Float y:Float
    entitas create -c Score value:Int
    entitas create -c SoundEffect effect:Int
    entitas create -c Tint r:Float g:Float b:Float a:Float
    entitas create -c Tween min:Float max:Float speed:Float repeat:Boolean active:Boolean
    entitas create -c Velocity x:Float y:Float
    entitas create -c View sprite:com.badlogic.gdx.graphics.g2d.Sprite
    entitas create -s Collision IExecuteSystem
    entitas create -s Destroy IExecuteSystem
    entitas create -s EntitySpawningTimer IExecuteSystem
    entitas create -s Expiring IExecuteSystem
    entitas create -s HealthRender IExecuteSystem
    entitas create -s Physics IExecuteSystem
    entitas create -s PlayerInput IInitializeSystem IExecuteSystem
    entitas create -s RemoveOffscreenShips IExecuteSystem
    entitas create -s ScaleTween IExecuteSystem
    entitas create -s ScoreRender IExecuteSystem
    entitas create -s SoundEffect IExecuteSystem
    entitas create -s SpriteRender IExecuteSystem
    entitas create -s ViewManager ISystem
    entitas generate -p scala mutable=var
