package com.zyx2.glambda.mmm;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class MeanMedianModeHandlerTest {

    private static HttpRequest request;

    @BeforeClass
    public static void createInput() throws IOException {
    	String body = "{\"data\": [1, 2, 3, 4, 5, 5, 5, 6]}";
        request = new HttpRequest();
        request.setBody(body);
    }

    private Context createContext() {
        TestContext ctx = new TestContext();
        ctx.setFunctionName("MeanMedianModeFunction");
        return ctx;
    }

    @Test
    public void testMeanMedianModeHandlerStatusCodeOkay() {
        MeanMedianModeHandler handler = new MeanMedianModeHandler();
        Context ctx = createContext();

        HttpResponse response = handler.handleRequest(request, ctx);
        Assert.assertEquals("200", response.getStatusCode());
    }
    
    @Test
    public void testMeanMedianModeHandlerStatusCodeISE() {
        MeanMedianModeHandler handler = new MeanMedianModeHandler();
        Context ctx = createContext();

        HttpResponse response = handler.handleRequest(new HttpRequest(), ctx);
        Assert.assertEquals("500", response.getStatusCode());
    }
}
