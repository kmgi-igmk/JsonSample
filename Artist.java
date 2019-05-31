package com.kmgi.jacksonSample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "birthDate", "age", "hometown", "awardsWon"})
public class Artist {
	@JsonProperty("Artist-Name")
    public String name;
    public Date birthDate;
    public int age;
    public String homeTown;
    public List<String> awardsWon = new ArrayList<String>();
}
