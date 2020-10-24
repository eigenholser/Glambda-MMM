package com.zyx2.glambda.mmm;

import java.util.Map;

public class HttpRequest {

	Map<String, String> queryStringParameters;
	Map<String, String> pathParameters;
	String body;

	public Map<String, String> getQueryStringParameters() {
		return queryStringParameters;
	}

	public Map<String, String> getPathParameters() {
		return pathParameters;
	}

	public String getBody() {
		return body;
	}

	// Needed for tests.
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "HttpRequest [queryStringParameters=" + queryStringParameters + ", pathParameters=" + pathParameters
				+ ", body=" + body + "]";
	}

}
