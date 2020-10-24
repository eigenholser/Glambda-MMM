package com.zyx2.glambda.mmm;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MeanMedianModeHandler implements RequestHandler<HttpRequest, HttpResponse> {

	@Override
	public HttpResponse handleRequest(HttpRequest request, Context context) {
		context.getLogger().log("HttpRequest: " + request);
		String errorMessage = "";

		if (request != null) {
			String body = request.getBody();
			Gson gson = new Gson();
			NumberSeries numberSeries = null;

			try {
				numberSeries = gson.fromJson(body, NumberSeries.class);
			} catch (JsonSyntaxException e) {
				errorMessage = "Bad request body syntax";
				context.getLogger().log(errorMessage + ": " + body);
				return getErrorResponse(errorMessage, Constants.HTTP_BAD_REQUEST);
			}

			context.getLogger().log("numberSeries " + numberSeries);
			if (numberSeries != null && numberSeries.getData() != null) {
				List<Float> numbers = numberSeries.getData();

				Float mean = Mean.compute(numbers);
				Float median = Median.compute(numbers);
				List<Float> mode = Mode.compute(numbers);

				return new HttpResponse(new ApiResult("Success", new MeanMedianMode(mean, median, mode)),
						Constants.HTTP_OK);
			} else {
				errorMessage = "numberSeries is null";
			}
		} else {
			errorMessage = "HttpRequest is null";
		}
		context.getLogger().log(errorMessage);
		return getErrorResponse(errorMessage, Constants.HTTP_BAD_REQUEST);
	}

	private HttpResponse getErrorResponse(String errorMessage, String statusCode) {
		HttpResponse response = new HttpResponse(new ApiResult(errorMessage, new MeanMedianMode()), statusCode);
		return response;
	}
}
