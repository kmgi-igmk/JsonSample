package com.kmgi.jacksonSample;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test1 {
	public static void main(String[] args) {

		String testJson1 =
				"{\"id\":1, \"name\":\"taro\", \"sikaku\":[\"応用\", \"基本\"]}";

		String testJson2 = "{\"id\":2, \"name\":\"jiro\"}";

		Sample1 sample1 = new Sample1();
		Sample1 sample2 = new Sample1();

		ObjectMapper mapper = new ObjectMapper();

		try {
			sample1 = mapper.readValue(testJson1, Sample1.class);
			sample2 = mapper.readValue(testJson2, Sample1.class);

			//Javaオブジェクトのデータの確認
			System.out.println(sample1.getId()); // 1
			System.out.println(sample1.getN()); // taro
			System.out.println(sample1.getSikaku()); // [基本, 応用]

			System.out.println(sample2.getId()); // 2
			System.out.println(sample2.getN()); // jiro
			System.out.println(sample2.getSikaku()); // null

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
