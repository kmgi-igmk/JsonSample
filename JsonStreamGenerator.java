
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

// albums.jsonを生成するサンプル
public class JsonStreamGenerator {
	public static void main(String[] args) throws IOException {
		JsonFactory factory = new JsonFactory();
		// srcと同階層のfileフォルダ内にalbum.jsonを生成
		JsonGenerator generator = factory.createGenerator(new FileWriter(new File("file/albums.json")));

				// start writing with {
		        generator.writeStartObject();
					
				// one set
		        generator.writeFieldName("title");
		        generator.writeString("Free Music Archive - Albums");
					
				// set the key name of the array
		        generator.writeFieldName("dataset");
		        // start an array
		        generator.writeStartArray();
		        generator.writeStartObject();
		        generator.writeStringField("album_title", "A.B.A.Y.A.M");
		        generator.writeEndObject();
		        generator.writeEndArray();
					
				// finish writing 
		        generator.writeEndObject();

		        generator.close(); //⇒{"title":"Free Music Archive - Albums","dataset":[{"album_title":"A.B.A.Y.A.M"}]}
	}
}
