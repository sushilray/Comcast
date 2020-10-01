# Validation Service

Validation service is an AWS Lambda Function that performs a vlidtion againest a Create Ingest payload:

 - Invalid Payload, in that case 400 sent as staus code with error message says " Invalid Payload".
 - Valid Payload, in this case, the validation process starts on three stages: (validation for checking required fields, checking fields values, and fileds formate)
 - If validation error occurr, a vliadtion error response will be sent with detailed error message and with 200 as status code.
 - If validtion completed with any error, a process of auto filling the generted fields should be done.

## Bulid

Run Maven command: > mvn clean package

## Test 

Unit testing can kicked by the Maven commnd: mvn clean test.

