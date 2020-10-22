# Glambda Code Challenge

An AWS Lambda that can compute mean, median, and mode of a series of numbers.

# Example POST Request Body

    {
        "data": [10, 2, 3, 4, 5, 6, 10, 100, 1]
    }

# Invoking the Lambda

    curl -v \
         -X POST \
         --header "Content-Type: application/json" \
         -d @data.json \
         https://9qy4uv108a.execute-api.us-west-2.amazonaws.com/dev

# Unit Tests

Invoke the unit tests:

    mvn test
