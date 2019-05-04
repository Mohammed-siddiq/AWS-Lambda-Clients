import calculator.{ConfigLoader, RestCalculatorClient, RpcCalculatorClient}
import io.grpc.calculator.Response
import org.scalatest.FlatSpec
import scalaj.http.Base64

class TestGRPCtLambdaClient extends FlatSpec {
  "Lambda client with Proto" should "Invoke the lambda function for addition with passed params and return the Proto result" in {


    //Verifying addition via lambda
    val restClient = new RpcCalculatorClient(20, 50, "+")

    //Invoking lambda function
    val response = restClient.runLambda()


    assert(response.output.equals(70.0))

  }
  /**
    * Testing lambda function for subtraction
    */
  "Lambda client with Proto" should "Invoke the lambda function for subtraction with passed params and return the Proto result" in {


    //Verifying addition via lambda
    val restClient = new RpcCalculatorClient(100, 50, "-")

    //Invoking lambda function
    val response = restClient.runLambda()


    assert(response.output.equals(50.0))

  }

  /**
    * Testing lambda function for multiplication
    */

  "Lambda client with Proto" should "Invoke the lambda function for multiplication with passed params and return the Proto result" in {


    //Verifying addition via lambda
    val restClient = new RpcCalculatorClient(100, 50, "*")

    //Invoking lambda function
    val response = restClient.runLambda()

    assert(response.output.equals(5000.0))
  }

  /**
    * Testing lambda function for division
    */

  "Lambda client with Proto" should "Invoke the lambda function for division with passed params and return the Proto result" in {


    //Verifying addition via lambda
    val restClient = new RpcCalculatorClient(100, 50, "/")

    //Invoking lambda function
    val response = restClient.runLambda()


    assert(response.output.equals(2.0))
  }
}
