package practiceDataDriverTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HowToReadDataFromJsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
          //step 1: parse Json physical file into java object using JsonParse class
		
		JSONParser parser =new JSONParser();
		Object obj=parser.parse(new FileReader("./src/test/resources/appCommonData.json"));
		
		//json format is like Hashmap 
		//step 2: convert java object into jsonobject using downcasting
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOut"));
	}

}
