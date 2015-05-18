/**
 * Created by dklucena on 18/05/15.
 */
object Utils {
    /*
  * Generates a ascii string of length n
  * */
  def randomString(n: Int): String = {
    n match {
      case 1 => util.Random.nextPrintableChar().toString
      case _ => util.Random.nextPrintableChar.toString ++ randomString(n - 1).toString
    }
  }

    /*
  * Complexity calculation is done like this
  *
  * First time alphanumeric    +2
  * subsequent times           +1
  * Special chars              +2
  *
  * A good complexity is a password that is at least containing each of the three and length >=8
  * (complexity > 15)
  * */
  def calculateComplexity(pass: String): Int = {

    var numCount = 0
    var lowerCharCount = 0
    var upperCharCount = 0
    var nonAlphaNumCount = 0

    for (x <- pass) {
      x match {
        case c: Char if c.isDigit => if (numCount == 0) numCount += 5 else numCount += 1
        case c: Char if c.isLower => if (lowerCharCount == 0) lowerCharCount += 5 else lowerCharCount += 1
        case c: Char if c.isUpper => if (upperCharCount == 0) upperCharCount += 5 else upperCharCount += 1
        case c: Char => nonAlphaNumCount += 5
      }
    }
    //TODO add also length calculation score

    return numCount + lowerCharCount + upperCharCount + nonAlphaNumCount
  }

}
