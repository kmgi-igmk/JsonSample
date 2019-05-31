package com.kmgi.jacksonSample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class SerializationExample {

    public static void main(String[] args) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        Album2 album = new Album2("Kind Of Blue");
        album.setLinks(new String[] { "link1", "link2" });
        List<String> songs = new ArrayList<String>();
        songs.add("So What");
        songs.add("Flamenco Sketches");
        songs.add("Freddie Freeloader");
        album.setSongs(songs);
        Artist2 artist = new Artist2();
        artist.name = "Miles Davis";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        artist.birthDate = format.parse("26/12/1926");
        album.setArtist(artist);
        album.addMusician("Miles Davis", "Trumpet, Band leader");
        album.addMusician("Julian Adderley", "Alto Saxophone");
        album.addMusician("Paul Chambers", "double bass");
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        mapper.setDateFormat(outputFormat);
//        mapper.setPropertyNamingStrategy(new PropertyNamingStrategy() {
//            @Override
//            public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
//                if (field.getFullName().equals("com.kmgi.jacksonSample.Artist2#name"))
//                    return "Artist-Name";
//                return super.nameForField(config, field, defaultName);
//            }
//
//            @Override
//            public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
//                if (method.getAnnotated().getDeclaringClass().equals(Album2.class) && defaultName.equals("title"))
//                    return "Album-Title";
//                return super.nameForGetterMethod(config, method, defaultName);
//            }
//        });
        mapper.setSerializationInclusion(Include.NON_EMPTY);
//        mapper.writeValue(System.out, album);
        System.out.println(mapper.writeValueAsString(album));
    }
}

class Album2 {
	@JsonProperty("Album-Title")
    private String title;
    private String[] links;
    private List<String> songs = new ArrayList<String>();
    private Artist2 artist;
    private Map<String, String> musicians = new HashMap<String, String>();

    public Album2(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    public String[] getLinks() {
        return links;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setArtist(Artist2 artist2) {
        this.artist = artist2;
    }

    public Artist2 getArtist() {
        return artist;
    }

    public Map<String, String> getMusicians() {
        return Collections.unmodifiableMap(musicians);
    }

    public void addMusician(String key, String value) {
        musicians.put(key, value);
    }
}

class Artist2 {
	@JsonProperty("Artist-Name")
    public String name;
    public Date birthDate;
    public int age;
    public String homeTown;
    public List<String> awardsWon = new ArrayList<String>();
}