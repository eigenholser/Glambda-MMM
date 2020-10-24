package com.zyx2.glambda.mmm;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class HttpResponse {

	private String body;
	private String statusCode = Constants.HTTP_OK;
	private Map<String, String> headers = new HashMap<String, String>();

	public HttpResponse() {
		this.headers.put("Content-Type", "application/json");
	}

	public HttpResponse(ApiResult result, String statusCode) {
		this();
		this.statusCode = statusCode;

		Gson gson = new Gson();
		this.body = gson.toJson(result);
	}

	public String getBody() {
		return body;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	@Override
	public String toString() {
		return "HttpResponse [body=" + body + ", statusCode=" + statusCode + ", headers=" + headers + "]";
	}
}
