package com.zyx2.glambda.mmm;

import java.util.List;

public class NumberSeries {
	private List<Float> data;

	public NumberSeries() {
	}

	public List<Float> getData() {
		return data;
	}

	public void setData(List<Float> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "NumberSeries [data=" + data + "]";
	}
}
