package com.kmgi.jacksonSample;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sample1 {
	private int id;

	@JsonProperty("name")
	private String n;

	private List<String> sikaku;

	public int getId() {
		return id;
	}

	public String getN() {
		return n;
	}

	public List<String> getSikaku() {
		return sikaku;
	}
}
