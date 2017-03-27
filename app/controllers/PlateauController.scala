package controllers

import akka.actor.Actor
import models.{Plateau, Rover}

/**
  * Created by synerzip on 21/2/17.
  */
class PlateauController extends Actor {
  def receive = {
    case plateau1: Plateau => {
      val rovList: List[Rover] = plateau1.rover
      val newList = rovList.map(r => {
        RoverController.fireCommand(r)
      })
      sender ! newList
    }
  }
}

