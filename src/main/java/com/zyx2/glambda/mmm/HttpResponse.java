package com.zyx2.glambda.mmm;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class HttpResponse {

	private String body;
	private String statusCode = Constants.HTTP_OK;
	private Map<String, String> headers = new HashMap<String, String>();

	public HttpResponse() {
		super();
		this.headers.put("Content-Type", "application/json");
	}
	
	public HttpResponse(MeanMedianMode mmm) {
		this();
		Gson gson = new Gson();
		this.body = gson.toJson(mmm);
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
}
