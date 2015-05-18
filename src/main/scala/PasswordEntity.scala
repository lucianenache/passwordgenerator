//import _root_.PasswordGeneratorService.MyJsonProtocol._
import spray.json.DefaultJsonProtocol

/**
 * Created by dklucena on 18/05/15.
 */
object PasswordEntity {
  case class Password(id: Int, pass: String, complexity: Int)

  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val PasswordFormat = jsonFormat3(Password)
  }
}
