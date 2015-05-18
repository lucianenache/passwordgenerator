package com.example

/**
 * Created by dklucena on 18/05/15.
 */

/* to fix the imports
class PasswordGeneratorSpec extends Specification with Specs2RouteTest with PasswordGeneratorService {
  def actorRefFactory = system

  "PasswordService" should {

    "return a password for GET requests to the /passge  path" in {
      Get() ~> myRoute ~> check {
        responseAs[String] must contain("???")
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/whatever") ~> myRoute ~> check {
        handled must beFalse
      }
    }

    "return a MethodNotAllowed error for PUT requests to the passgen path" in {
      Put() ~> sealRoute(myRoute) ~> check {
        status === MethodNotAllowed
        responseAs[String] === "HTTP method not allowed, supported methods: GET"
      }
    }
  }
}
*/