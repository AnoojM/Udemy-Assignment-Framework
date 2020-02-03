package test.scala.simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

import test.scala.config._
import test.scala.scenario._


class HotelSimulation extends Simulation {

  setUp(Scenarios.scnHotelList
  .inject(constantConcurrentUsers(5) during(5 seconds), rampConcurrentUsers(5) to (15) during(10 seconds)))
    .protocols(Constants.httpProtocol)
    .assertions(global.successfulRequests.percent.is(100))
}
