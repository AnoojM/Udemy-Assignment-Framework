package test.scala.config

import ch.qos.logback.classic.{Level,LoggerContext}
import org.slf4j.LoggerFactory
object Utills {

  def debugInfo():Unit = {
    if(Constants.isDebug) {
      val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
      context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    }
  }

}
