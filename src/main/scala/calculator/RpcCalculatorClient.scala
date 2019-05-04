package calculator


import io.grpc.calculator.{Input, Response}
import scalaj.http.{Base64, Http, HttpResponse}

/**
  * A RPC rest client that creates a protobuffer binary request and reads the response as a protobuffer binary
  *
  * @param op1      operand 1
  * @param op2      operand 2
  * @param operator operator
  */
class RpcCalculatorClient(op1: Double, op2: Double, operator: String) extends App {


  def runLambda(): Response = {


    println("Sending Request Proto .... ")


    //Creating protobufferr input message
    val data = Input(op1, op2, operator)

    println(data.toString)

    // Sending the protobuf binary array as a request to AWS lambda
    val result = Http(ConfigLoader.END_POINT).postData(data.toByteArray)
      .header(ConfigLoader.CONTENT_TYPE_STR, ConfigLoader.GRPC_CONTENT_TYPE)
      .header(ConfigLoader.X_API_KEY_STR, ConfigLoader.X_API_KEY).asString


    //Performing base64 decoding of the response proto
    val raw_body = Base64.decode(result.body)

    //constructing the response proto from the binary array
    val returnedResponse = Response.parseFrom(raw_body)

    println("Response form the lambda function ")

    println(returnedResponse.toString)

    returnedResponse

  }
}
