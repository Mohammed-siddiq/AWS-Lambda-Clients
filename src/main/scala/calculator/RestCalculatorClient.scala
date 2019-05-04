package calculator

import scalaj.http.{Http, HttpResponse}

/**
  * A Rest calculator client that creates a sample http GET request to the LAMBDA
  *
  * @param op1      : Operand 1
  * @param op2      Operand 2
  * @param operator Operator (+,-.*,/)
  */
class RestCalculatorClient(op1: Double, op2: Double, operator: String) extends App {

  def runLambda(): HttpResponse[String] = {
    println("Making Get Request .... ")

    val result = Http(ConfigLoader.END_POINT).param(ConfigLoader.OPERAND_1, op1.toString).
      param(ConfigLoader.OPERAND_2, op2.toString).
      param(ConfigLoader.OPERATOR, operator)
      .header(ConfigLoader.X_API_KEY_STR, ConfigLoader.X_API_KEY).asString


    println("Response form the lambda function ")

    println(result.body)
    result

  }


}
