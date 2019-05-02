package calculator


import io.grpc.calculator.{Input, Response}
import scalaj.http.{Base64, Http}


object RpcCalculatorClient extends App {

  println("Sending Request Proto .... ")

  val data = Input(500, 100, "+")

  println(data.toString)

  val result = Http("https://a4r9djxhra.execute-api.us-east-1.amazonaws.com/default/CalculatorLambda").postData(data.toByteArray)
    .header("Content-Type", "application/grpc+proto")
    .header("x-api-key", "QDqkEgvLZZ2rqt5RlZ6Gx2SpOm0FsFRE5yjsByQZ").asString


  val raw_body = Base64.decode(result.body)

  val returnedResponse = Response.parseFrom(raw_body)

  println("Response form the lambda function ")

  println(returnedResponse.toString)


}
