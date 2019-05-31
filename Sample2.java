package com.kmgi.jacksonSample;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sample2 {
	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String n;

	@JsonProperty("sikaku")
	private List<String> sikaku;

	public void setId(int id) {
		this.id = id;
	}
	public void setN(String n) {
		this.n = n;
	}
	public void setSikaku(List<String> sikaku) {
		this.sikaku = sikaku;
	}
}
