import calculator.{ConfigLoader, RestCalculatorClient}
import org.scalatest.FlatSpec

class TestRESTLambdaClient extends FlatSpec {

  /**
    * Testing lambda function for addition
    */

  "Lambda client with JSON" should "Invoke the lambda function for addition with passed params and return the JSON result" in {


    //Verifying addition via lambda
    val restClient = new RestCalculatorClient(20, 50, "+")

    //Invoking lambda function
    val response = restClient.runLambda()

    println("content-type" + response.contentType.get)
    assert(response.contentType.get.equals(ConfigLoader.JSON_CONTENT_TYPE))
    assert(response.body.contains(70.0.toString))

  }
  /**
    * Testing lambda function for subtraction
    */
  "Lambda client with JSON" should "Invoke the lambda function for subtraction with passed params and return the JSON result" in {


    //Verifying addition via lambda
    val restClient = new RestCalculatorClient(100, 50, "-")

    //Invoking lambda function
    val response = restClient.runLambda()

    println("content-type" + response.contentType.get)
    assert(response.contentType.get.equals(ConfigLoader.JSON_CONTENT_TYPE))
    assert(response.body.contains(50.0.toString))

  }

  /**
    * Testing lambda function for multiplication
    */

  "Lambda client with JSON" should "Invoke the lambda function for multiplication with passed params and return the JSON result" in {


    //Verifying addition via lambda
    val restClient = new RestCalculatorClient(100, 50, "*")

    //Invoking lambda function
    val response = restClient.runLambda()

    println("content-type" + response.contentType.get)
    assert(response.contentType.get.equals(ConfigLoader.JSON_CONTENT_TYPE))
    assert(response.body.contains(5000.0.toString))

  }

  /**
    * Testing lambda function for division
    */

  "Lambda client with JSON" should "Invoke the lambda function for division with passed params and return the JSON result" in {


    //Verifying addition via lambda
    val restClient = new RestCalculatorClient(100, 50, "/")

    //Invoking lambda function
    val response = restClient.runLambda()

    println("content-type" + response.contentType.get)
    assert(response.contentType.get.equals(ConfigLoader.JSON_CONTENT_TYPE))
    assert(response.body.contains(2.0.toString))

  }


}
