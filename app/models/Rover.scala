package models

import play.api.libs.json._

/**
  * Created by synerzip on 6/3/17.
  */

case class Rover(
                  roverXco: Int,
                  roverYco: Int,
                  roverFace: String,
                  roverCmd: String
                )

object Rover {
  implicit var implicitRoverWrites = new Format[Rover] {

    def writes(s: Rover): JsValue = {
      Json.obj("roverXco" -> JsNumber(s.roverXco),
        "roverYco" -> JsNumber(s.roverYco),
        "roverFace" -> JsString(s.roverFace))
    }

    def reads(json: JsValue): JsResult[Rover] = {
      val roverXco = (json \ "roverXco").as[Int]
      val roverYco = (json \ "roverYco").as[Int]
      val roverFace = (json \ "roverFace").as[String]
      val roverCmd = (json \ "roverCmd").as[String]
      JsSuccess(Rover(roverXco, roverYco, roverFace, roverCmd))
    }
  }

}
