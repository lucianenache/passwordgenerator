import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http
import scala.concurrent.duration._

/**
 * Created by dklucena on 18/05/15.
 */
object Boot extends App {
  implicit val actorSystem = ActorSystem()

  val service = actorSystem.actorOf(Props[MyServiceActor], "passgen-service")

  implicit val timeout = Timeout(5.seconds)

  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
}
