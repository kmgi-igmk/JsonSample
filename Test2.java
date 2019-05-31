package com.kmgi.jacksonSample;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test2 {
	public static void main(String[] args) {
		Sample2 sample1 = new Sample2();
		Sample2 sample2 = new Sample2();

		List<String> sikaku = new ArrayList<>();
		sikaku.add("基本");
		sikaku.add("応用");

		sample1.setId(1);
		sample1.setN("taro");
		sample1.setSikaku(sikaku);

		sample2.setId(2);
		sample2.setN("jiro");

		ObjectMapper mapper = new ObjectMapper();

		try {
			String testJson1 = mapper.writeValueAsString(sample1);
			String testJson2 = mapper.writeValueAsString(sample2);

			System.out.println(testJson1);
			System.out.println(testJson2);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
