package com.zyx2.glambda.mmm;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MeanMedianModeHandler implements RequestHandler<HttpRequest, HttpResponse> {

    @Override
    public HttpResponse handleRequest(HttpRequest request, Context context) {
        context.getLogger().log("Input: " + request);

        return new HttpResponse(new MeanMedianMode(1.23f, 3.45f, 5.67f));
    }
}
