# Overview

AWS Lambda Client implementation with ProtoBuffers and REST methods.
 
 
# Description

Uses ProtoBuffers for communication where the lambda receives request as a protobuff
binary and responds the request with a protobuff.


## Protcol Buffers

The following is the ProtoBuff declaration for the Input message:

```proto

message Input {

    double op1 = 1;

    double op2 = 2;

    string operator = 3;

}
```

Response Message:

```proto

message Response {
    string inputExpression = 1;
    double output = 2;
    string message = 3;
}
```

And the service:

```proto
service Calculator {
    rpc Calculate (Input) returns (Response);
}
```

## Requests and Response


##### GRPC REQUEST 

```scala
Http("API EndPoint").postData(protoBuffInputMessage.toByteArray)
    .header("Content-Type", "application/grpc+proto")
    .header("x-api-key", "yourApiKey").asString
```

Sample Request Proto received by the handler

```
Protobuf received
-------------------------
op1: 500.0
op2: 100.0
operator: "+"
```

##### GRPC Response

Sample Proto Response sent by the handler

```
Returning Protobuf
-------------------------
inputExpression: "500.0+100.0"
output: 600.0
message: "Success"
```

#

##### HTTP Request

```yaml
curl -X GET \
  'https://a4r9djxhra.execute-api.us-east-1.amazonaws.com/default/CalculatorLambda?op1=1292922&op2=339.33&operator=%2B' \
  -H 'Postman-Token: 28fc6f99-1138-4cac-a67a-4f5bd75469f4' \
  -H 'cache-control: no-cache' \
  -H 'x-api-key: QDqkEgvLZZ2rqt5RlZ6Gx2SpOm0FsFRE5yjsByQZanan'
```

##### JSON Response 

```json
{
    "inputExpression": "1292922.0 + 339.33",
    "output": 1293261.33,
    "message": "success"
}
```



# Steps to run

Run the clients to test the lambda function using the following command

```sbtshell
sbt clean test
```

This will run the tests for both REST and GRPC clients .

## Sample output run of the clients 

```$xslt
[info] TestGRPCtLambdaClient:
[info] Lambda client with Proto
[info] - should Invoke the lambda function for addition with passed params and return the Proto result
[info] Lambda client with Proto
[info] - should Invoke the lambda function for subtraction with passed params and return the Proto result
[info] Lambda client with Proto
[info] - should Invoke the lambda function for multiplication with passed params and return the Proto result
[info] Lambda client with Proto
[info] - should Invoke the lambda function for division with passed params and return the Proto result

[info] TestRESTLambdaClient:
[info] Lambda client with JSON
[info] - should Invoke the lambda function for addition with passed params and return the JSON result
[info] Lambda client with JSON
[info] - should Invoke the lambda function for subtraction with passed params and return the JSON result
[info] Lambda client with JSON
[info] - should Invoke the lambda function for multiplication with passed params and return the JSON result
[info] Lambda client with JSON
[info] - should Invoke the lambda function for division with passed params and return the JSON result
[info] Run completed in 4 seconds, 245 milliseconds.
[info] Total number of tests run: 8
[info] Suites: completed 2, aborted 0
[info] Tests: succeeded 8, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 16 s, completed May 3, 2019, 10:51:50 PMeturn the Proto result
```
.

### Lambda Function Deployed

![Lambda Function](ScreenShots/LambdaFunction.png)

##

### Lambda Media Type Setting For GRPC

![Lambda Media Type](ScreenShots/LambdaMediaType.png)

##

### Lambda Function Stages

![Lambda Stages](ScreenShots/LambdaStages.png)

##

### CloudWatch Metrics

![Lambda Media Type](ScreenShots/LamdaCloudWatchMetrics.png)

##

### CloudWatch Logs

![CloudWatch Logs](ScreenShots/CloudwatchLogs.png)

##
