package models

import play.api.libs.json._

/**
  * Created by synerzip on 21/3/17.
  */
case class Plateau(
                    upperRightXco: Int,
                    upperRightYco: Int,
                    numOfRov: Int,
                    rover: List[Rover]
                  )

object Plateau {
  implicit var implicitRoverWrites = new Format[Plateau] {

    def writes(s: Plateau): JsValue = {
      Json.obj("upperRightXco" -> JsNumber(s.upperRightXco),
        "upperRightYco" -> JsNumber(s.upperRightYco),
        "numOfRov" -> JsNumber(s.numOfRov))
    }

    def reads(json: JsValue): JsResult[Plateau] = {
      val upperRightXco = (json \ "upperRightXco").as[Int]
      val upperRightYco = (json \ "upperRightYco").as[Int]
      val numOfRov = (json \ "numOfRov").as[Int]
      val rovers: List[Rover] = (json \ "rover").as[JsArray].value.map(r => r.as[Rover]).toList

      JsSuccess(Plateau(upperRightXco, upperRightYco, numOfRov, rovers))
    }
  }
}
