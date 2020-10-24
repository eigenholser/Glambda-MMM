package com.zyx2.glambda.mmm;

public class ApiResult {
	private MeanMedianMode result;
	private String status;

	public ApiResult() {

	}

	public ApiResult(String status, MeanMedianMode result) {
		this.result = result;
		this.status = status;
	}

	public MeanMedianMode getResult() {
		return result;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "ApiResult [result=" + result + ", status=" + status + "]";
	}
}
