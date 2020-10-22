package com.zyx2.glambda.mmm;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

public class MeanMedianModeHandler implements RequestHandler<HttpRequest, HttpResponse> {

	@Override
	public HttpResponse handleRequest(HttpRequest request, Context context) {
		context.getLogger().log("HttpRequest: " + request);

		String body = request.getBody();
		Gson gson = new Gson();
		NumberSeries numberSeries = gson.fromJson(body, NumberSeries.class);
		
		if (numberSeries == null) {
			HttpResponse response = new HttpResponse();
			response.setStatusCode("500");
			return response;
		}
		
		List<Float> numbers = numberSeries.getData();
		
		Float mean = Mean.computeMean(numbers);
		Float median = Median.computeMedian(numbers);
		Float mode = Mode.computeMode(numbers);
		
		return new HttpResponse(new MeanMedianMode(mean, median, mode));
	}
}
