package controllers

import models.Rover

/**
  * Created by synerzip on 21/2/17.
  */
object RoverController {
  /**
    * Function to fire commands for Rover r
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def fireCommand(rover: Rover): Rover = {
    var rov = rover
    val cmdArray = rov.roverCmd.split("")
    val rcmd: Array[String] = cmdArray
    rcmd.foreach {
      case "L" =>
        rov = moveLeft(rov)
      case "R" =>
        rov = moveRight(rov)
      case "M" =>
        rov = move(rov)
      case _ => println("Invalid Command")
    }
    rov
  }

  /**
    * Function to move left When Rover having left command & also to change its face
    *
    * @param rover -Rover Object which contains current position of Rover
    */
  def moveLeft(rover: Rover): Rover = {
    val currentFace: String = rover.roverFace
    currentFace match {
      case "E" =>
        rover.copy(roverFace = "N")
      case "N" =>
        rover.copy(roverFace = "W")
      case "W" =>
        rover.copy(roverFace = "S")
      case "S" =>
        rover.copy(roverFace = "E")
      case _ => println("Invalid Face Direction")
        rover.copy()
    }

  }

  /**
    * Function to move & change its face When Rover having move Right command
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def moveRight(rover: Rover): Rover = {
    val currentFace: String = rover.roverFace
    currentFace match {
      case "E" =>
        rover.copy(roverFace = "S")
      case "S" =>
        rover.copy(roverFace = "W")
      case "W" =>
        rover.copy(roverFace = "N")
      case "N" =>
        rover.copy(roverFace = "E")
      case _ => println("Invalid Face Direction")
        rover.copy()
    }
  }

  /**
    * Function to move When Rover having move command & to change its position
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def move(rover: Rover): Rover = {
    val currentFace: String = rover.roverFace
    val rovxCo: Int = rover.roverXco
    val rovyCo: Int = rover.roverYco
    currentFace match {
      case "E" =>
        rover.copy(roverXco = rovxCo + 1)
      case "S" =>
        rover.copy(roverYco = rovyCo - 1)
      case "W" =>
        rover.copy(roverXco = rovxCo - 1)
      case "N" =>
        rover.copy(roverYco = rovyCo + 1)
      case _ => println("Invalid Face Direction")
        rover.copy()
    }
  }
}
