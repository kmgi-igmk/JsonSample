package com.kmgi.jacksonSample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AlbumJson {
	public static void main(String[] args) throws IOException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		Album album = new Album("Kind Of Blue");
		album.setLinks(new String[] { "link1", "link2" });

		List<String> songs = new ArrayList<>();
		songs.add("So What");
		songs.add("Flamenco dance");
		songs.add("Free loader");
		album.setSongs(songs);

		Artist artist = new Artist();
		artist.name = "Miles Davis";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		artist.birthDate = format.parse("04-05-1999");
		album.setArtist(artist);

		album.addMusician("Miles Davis", "Trumpet, Band leader");
		album.addMusician("Julian Adderley", "Alto Saxophone");
		album.addMusician("Paul Chambers", "double bass");

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
        mapper.setDateFormat(outputFormat);
//        mapper.setPropertyNamingStrategy(new PropertyNamingStrategy() {
//            @Override
//            public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
//                if (field.getFullName().equals("com.kmgi.jacksonSample.Artist#name"))
//                    return "Artist-Name";
//                return super.nameForField(config, field, defaultName);
//            }
//
//            @Override
//            public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
//                if (method.getAnnotated().getDeclaringClass().equals(Album.class) && defaultName.equals("title"))
//                    return "Album-Title";
//                return super.nameForGetterMethod(config, method, defaultName);
//            }
//        });
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        mapper.writeValue(System.out, album);
	}
}
