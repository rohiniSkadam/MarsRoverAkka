package controllers

import akka.actor.{Actor, Props}
import akka.pattern.ask
import akka.util.Timeout
import models.{Plateau, Rover}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by synerzip on 21/2/17.
  */
class PlateauController extends Actor {
  def receive = {
    case plateau1: Plateau => {
      val roverControlActor = context.system.actorOf(Props[RoverController], name = "roverControlActor")
      val rovList: List[Rover] = plateau1.rover
      implicit val timeout = Timeout(5 seconds)
      val future = roverControlActor ? rovList
      val result = Await.result(future, timeout.duration).asInstanceOf[List[Rover]]
      sender ! result
    }
  }
}