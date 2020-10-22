package com.zyx2.glambda.mmm;

public class MeanMedianMode {
	private float mean;
	private float median;
	private float mode;

	public MeanMedianMode() {

	}

	public MeanMedianMode(float mean, float median, float mode) {
		super();
		this.mean = mean;
		this.median = median;
		this.mode = mode;
	}

	public float getMean() {
		return mean;
	}

	public void setMean(float mean) {
		this.mean = mean;
	}

	public float getMedian() {
		return median;
	}

	public void setMedian(float median) {
		this.median = median;
	}

	public float getMode() {
		return mode;
	}

	public void setMode(float mode) {
		this.mode = mode;
	}
}
