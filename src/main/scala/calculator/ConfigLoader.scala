package calculator

import com.typesafe.config.ConfigFactory

/**
  * A singleton config loader for the entire application
  */
object ConfigLoader {
  val conf = ConfigFactory.load("application")
  val X_API_KEY_STR = conf.getString("RAW_X_API_KEY")
  val X_API_KEY = conf.getString("X_API_KEY")
  val END_POINT = conf.getString("END_POINT")

  val CONTENT_TYPE_STR = conf.getString("CONTENT_TYPE_STR")
  val GRPC_CONTENT_TYPE = conf.getString("GRPC_CONTENT_TYPE")
  val JSON_CONTENT_TYPE = conf.getString("JSON_CONTENT_TYPE")
  val OPERAND_1 = conf.getString("OPERAND_1")
  val OPERAND_2 = conf.getString("OPERAND_2")
  val OPERATOR = conf.getString("OPERATOR")
}
