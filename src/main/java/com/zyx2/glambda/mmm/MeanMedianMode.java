package com.zyx2.glambda.mmm;

import java.util.List;

public class MeanMedianMode {
	private Float mean;
	private Float median;
	private List<Float> mode;

	public MeanMedianMode() {

	}

	public MeanMedianMode(Float mean, Float median, List<Float> mode) {
		this.mean = mean;
		this.median = median;
		this.mode = mode;
	}

	public Float getMean() {
		return mean;
	}

	public void setMean(Float mean) {
		this.mean = mean;
	}

	public Float getMedian() {
		return median;
	}

	public void setMedian(Float median) {
		this.median = median;
	}

	public List<Float> getMode() {
		return mode;
	}

	public void setMode(List<Float> mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "MeanMedianMode [mean=" + mean + ", median=" + median + ", mode=" + mode + "]";
	}
}
