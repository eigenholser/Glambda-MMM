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
        request = null;
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("MeanMedianModeFunction");

        return ctx;
    }

    @Test
    public void testMeanMedianModeHandlerStatusCode() {
        MeanMedianModeHandler handler = new MeanMedianModeHandler();
        Context ctx = createContext();

        HttpResponse output = handler.handleRequest(request, ctx);
        Assert.assertEquals("200", output.getStatusCode());
    }
}
