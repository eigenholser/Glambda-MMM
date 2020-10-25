package com.zyx2.glambda.mmm;

public class ApiResult {
	private MeanMedianMode result;
	private String message;

	public ApiResult() {

	}

	public ApiResult(String message, MeanMedianMode result) {
		this.result = result;
		this.message = message;
	}

	public MeanMedianMode getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ApiResult [result=" + result + ", message=" + message + "]";
	}
}
