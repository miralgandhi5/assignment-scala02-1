package edu.knoldus

import org.apache.log4j.Logger

object Application extends App {

  val log = Logger.getLogger(this.getClass)

  val firstMember = 10
  val secondMember = 20
  val thirdMember = 30
  val fourthMember = 40
  val firstMemberSec = 10
  val firstMemberThird = 10
  val thirdMemberSec = 30
  val fourthMemberSec = 40
  val times = 2
  val inputListOne = (19 to 22).toList
  val inputListTwo = List(firstMember, firstMemberSec, firstMemberThird, secondMember, thirdMember, thirdMemberSec, fourthMember, fourthMemberSec)
  log.info(s" List before rotation $inputListOne \n ")
  val outputList = Operations.rotateNPlaces(inputListOne, times)
  log.info(s" List after rotation $times times is $outputList \n ")
  val result: List[String] = Operations.happyOrSadNum(inputListOne)
  result foreach print
  log.info(s" List before removing consecutive duplicates $inputListTwo \n ")
  log.info(s" List after removing duplicates ${Operations.removeConsecutive(inputListTwo)} \n ")

}
