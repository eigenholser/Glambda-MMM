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
	private static MeanMedianModeHandler handler = new MeanMedianModeHandler();
	private static HttpRequest goodRequest;
	private static HttpRequest badRequest1;
	private static HttpRequest badRequest2;

	@BeforeClass
	public static void createInput() throws IOException {
		String goodBody = "{\"data\": [1, 2, 3, 4, 5, 5, 5, 6]}";
		goodRequest = new HttpRequest();
		goodRequest.setBody(goodBody);

		// Malformed JSON
		String badBody1 = "{\"data\": [1, 2, 3, 4, 5, 5, 5, 6]";
		badRequest1 = new HttpRequest();
		badRequest1.setBody(badBody1);

		// Unexpected data
		String badBody2 = "{\"foo\": [1, 2, 3, 4, 5, 5, 5, 6]}";
		badRequest2 = new HttpRequest();
		badRequest2.setBody(badBody2);
	}

	private Context createContext() {
		TestContext ctx = new TestContext();
		ctx.setFunctionName("MeanMedianModeFunction");
		return ctx;
	}

	@Test
	public void testMeanMedianModeHandlerStatusCodeOkay() {
		Context ctx = createContext();
		HttpResponse response = handler.handleRequest(goodRequest, ctx);
		Assert.assertEquals(Constants.HTTP_OK, response.getStatusCode());
	}

	@Test
	public void testMeanMedianModeHandlerStatusCodeError() {
		Context ctx = createContext();
		HttpResponse response = handler.handleRequest(new HttpRequest(), ctx);
		Assert.assertEquals(Constants.HTTP_BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void testMeanMedianModeHandlerBadBody() {
		Context ctx = createContext();
		HttpResponse response = handler.handleRequest(badRequest1, ctx);
		Assert.assertEquals(Constants.HTTP_BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void testMeanMedianModeHandlerUnexpectedData() {
		Context ctx = createContext();
		HttpResponse response = handler.handleRequest(badRequest2, ctx);
		Assert.assertEquals(Constants.HTTP_BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void testMeanMedianModeHandlerNullRequest() {
		Context ctx = createContext();
		HttpResponse response = handler.handleRequest(null, ctx);
		Assert.assertEquals(Constants.HTTP_BAD_REQUEST, response.getStatusCode());
	}
}
