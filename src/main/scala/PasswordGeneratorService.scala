import PasswordEntity.MyJsonProtocol._
import PasswordEntity.Password
import akka.actor.Actor
import org.slf4j.LoggerFactory
import spray.httpx.SprayJsonSupport._
import spray.routing.HttpService

/**
 * Created by dklucena on 13/05/15.
 */

class MyServiceActor extends Actor with PasswordGeneratorService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(passRoute)


}

trait PasswordGeneratorService extends HttpService {

  implicit var id = 0;
  val logger = LoggerFactory.getLogger(getClass)

  def newPass(cplx: Int): Password = {
    id += 1
    val pass = Utils.randomString(cplx)
    val p = Password(id, pass, Utils.calculateComplexity(pass))
    return p
  }

  //TODO missing default and non numeric controls for the route
  val passRoute = (path("passgen" / IntNumber) & get) { length =>
    complete {
      if(length > 0){
        logger.debug(s"new password generated of length $length")
        newPass(length)
      }
      else {
        logger.debug("using default length 8 when no length specified")
        newPass(8)
      }

    }
  }


}


