package com.kmgi.jacksonSample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"title", "links", "songs", "artist", "musicians"})
public class Album {
	@JsonProperty("Album-title")
	private String title;
	private String[] links;
	private List<String> songs = new ArrayList<>();
	private Artist artist;
	private Map<String, String> musicians = new HashMap<String, String>();


	public Album(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getLinks() {
		return links;
	}

	public void setLinks(String[] links) {
		this.links = links;
	}

	public List<String> getSongs() {
		return songs;
	}

	public void setSongs(List<String> songs) {
		this.songs = songs;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Map<String, String> getMusicians() {
		return Collections.unmodifiableMap(musicians);
	}

	public void addMusician(String key, String value) {
		musicians.put(key, value);
	}

 }
