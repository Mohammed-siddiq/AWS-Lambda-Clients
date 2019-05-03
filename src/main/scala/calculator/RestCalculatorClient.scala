package calculator

import scalaj.http.Http

/**
  * A Rest calculator client that creates a sample http GET request to the LAMBDA
  */
object RestCalculatorClient extends App {
  println("Making Get Request .... ")


  val result = Http(ConfigLoader.END_POINT).param("op1", "10.33").
    param("op2", "30").
    param("operator", "-")
    .header(ConfigLoader.X_API_KEY_STR, ConfigLoader.X_API_KEY).asString


  println("Response form the lambda function ")

  println(result.body)
}
