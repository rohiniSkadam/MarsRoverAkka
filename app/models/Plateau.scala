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
  implicit val plateauFormat = Json.format[Plateau]
}
