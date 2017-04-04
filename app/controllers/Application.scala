package controllers

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import models.{Plateau, Rover}
import play.api.mvc.{Action, Controller}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import akka.pattern.ask
import scala.concurrent.duration._


import scala.concurrent.{Await, Future}

object Application extends Controller with App {
  import play.api.libs.json.Json
  def roverPositions = Action.async { request =>
    val system = ActorSystem("AskTestSystem")
    val plateauControlActor = system.actorOf(Props[PlateauController], name = "plateauControlActor")

    implicit val timeout = Timeout(5 seconds)
    val jsonRequest = request.body.asJson.get
    val plateau = jsonRequest.as[Plateau]
    val future = plateauControlActor ? plateau
    val result = Await.result(future, timeout.duration).asInstanceOf[List[Rover]]
    Future(Ok(Json.toJson(result)))
  }
}




