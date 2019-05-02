package calculator

import scalaj.http.Http

object RestCalculatorClient extends App {
  println("Making Get Request .... ")


  val result = Http("https://a4r9djxhra.execute-api.us-east-1.amazonaws.com/default/CalculatorLambda").param("op1", "10").
    param("op2", "30").
    param("operator", "*")
    .header("x-api-key", "QDqkEgvLZZ2rqt5RlZ6Gx2SpOm0FsFRE5yjsByQZ").asString


  
  println("Response form the lambda function ")

  println(result.body)
}
