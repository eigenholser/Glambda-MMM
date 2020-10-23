# Glambda Code Challenge

An AWS Lambda that can compute mean, median, and mode of a series of numbers.

## Solution

Implement a simple unauthenticated and non-REST API that will process the POST
request body and compute the mean, median, and mode from the series of numbers
contained in the array.

## Example POST Request Body

    {
        "data": [10, 2, 3, 4, 5, 6, 10, 100, 1]
    }

## Example Response

    {
        "mean": 15.666667,
        "median": 5.0,
        "mode": [10.0]
    }

## Invoking the Lambda

Assuming JSON request body is contained in file `data.json`:

    curl -v \
         -X POST \
         --header "Content-Type: application/json" \
         -d @data.json \
         https://9qy4uv108a.execute-api.us-west-2.amazonaws.com/dev

## Unit Tests and Code Coverage

Invoke the unit tests:

    mvn test

Code coverage reports:

    mvn jacoco:report
    firefox target/site/jacoco/index.html
