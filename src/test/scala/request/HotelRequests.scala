package test.scala.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import test.scala.config._

object HotelRequests {

  val getHotelList = tryMax(2){exec(http("getHotelList").get("/api/voyager/get_hotels_by_cityid/?app_id=" + Constants.appId + "&app_key=" + Constants.appKey + "&city_id=${City ID}")
  .check(jsonPath("$.data..hotel_geo_node._id").findAll.saveAs("myHotelIds")))}.exitHereIfFailed
    .exec(session=> {
      //println(session("myHotelIds").as[String])
      val hotelIdVector = session("myHotelIds").as[Vector[String]]
      var firstHotelIdVector = hotelIdVector(0)
      var secondHotelIdVector = hotelIdVector(1)
      session.set("firstHotelId",firstHotelIdVector).set("secondHotelId",secondHotelIdVector)
    })
  val getHotelDetails = exec(http("getHotelDetails").get("/api/voyager/?app_id="+Constants.appId+"&app_key="+Constants.appKey+"&method=hotels.get_hotels_data&id_list=%5B${firstHotelId}%2C${secondHotelId}%5D&id_type=_id")
  .check(bodyString.saveAs("myResponse")))
    /*.exec(session=> {
      println(session("myResponse").as[String])
      session
    })*/
}
