package edu.knoldus

object Operations {

  def runLength(list: List[Int]): List[(Int, Int)] = {

    def innerRun(input: List[Int], output: List[(Int, Int)]): List[(Int, Int)] = {
      input match {
        case Nil => output
        case head :: _ => val res = input.span(_ == head)
          innerRun(res._2, output :+ (head, res._1.length))
      }
    }

    innerRun(list, List.empty[(Int, Int)])
  }

  def removeConsecutive(list: List[Int]): List[Int] = {

    def innerRemoveConsecutive(input: List[Int], output: List[Int]): List[Int] = {
      input match {
        case Nil => output
        case head :: head2 :: tail if head == head2 =>
          innerRemoveConsecutive(head2 :: tail, output)
        case head :: tail => innerRemoveConsecutive(tail, output :+ head)
      }
    }

    innerRemoveConsecutive(list, List.empty[Int])
  }

  def rotateNPlaces(list: List[Int], times: Int): List[Int] = {

    def rotateOnce(input: List[Int], current: Int): List[Int] = {
      input match {
        case _ :: _ if current == 0 => input
        case head :: tail => rotateOnce(tail :+ head, current - 1)
        case Nil => list
      }
    }

    if (times > 0) {
      rotateOnce(list, times)
    }
    else {
      list
    }

  }

  def happyOrSadNum(list: List[Int]): List[String] = {

    def checkNum(value: Int, current: Int, outputList: List[Int]): String = {

      val res: Int = sumOfSquare(current, 0)


      if (isContains(outputList, res)) {
        s"$value is sad number\n"
      }
      else if (res == 1) {
        s"$value is happy number\n"
      }
      else {
        checkNum(value, res, outputList :+ res)
      }
    }

    for (ele <- list) yield checkNum(ele, ele, List.empty[Int])
  }

  private def sumOfSquare(value: Int, res: Int): Int = {
    if (value != 0) {
      sumOfSquare(value / 10, res + ((value % 10) * (value % 10)))
    }
    else {
      res
    }
  }

  private def isContains(list: List[Int], value: Int): Boolean = {

    def checkNumber(input: List[Int]): Boolean = {
      input match {
        case Nil => false
        case head :: _ if head == value => true
        case _ :: tail => checkNumber(tail)
      }
    }

    checkNumber(list)
  }


}
