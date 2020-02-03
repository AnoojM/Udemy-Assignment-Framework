package test.scala.config

import com.typesafe.config._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Constants {

  val conf = ConfigFactory.load("app.properties")

  //Application Details
  val baseUrl = conf.getString("baseUrl")
  val appId = conf.getString("appId")
  val appKey = conf.getString("appKey")

  //Scenario Details
  val repeatTimes = conf.getString("repeat").toInt
  val pause = conf.getString("pauseBetweenRequestsMs").toInt
  val pace = conf.getString("paceInMs").toInt
  val isDebug = conf.getString("isDebug").toBoolean

  // Simulation Details
  val httpProtocol = http.baseUrl(baseUrl)
  //Hotel scenario Details
  val hotelCsvFeeder = csv(conf.getString("hotelDataFile"))


}
