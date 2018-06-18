package by.drozdovskaya.serverstring.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WorkWithFile {

	private static final String RELATIVE_LOCATION_FILE = "resources\\";
	
	public void fileExists(String name) {
		
		if(! new File(RELATIVE_LOCATION_FILE + name + ".txt").exists());{
			File file = new File(RELATIVE_LOCATION_FILE + name + ".txt");
		}
		
	}

	public String readFromFile(String name) {
		this.fileExists(name);
		char [] data = new char[1024];
		String text = new String();
		try(FileReader reader = new FileReader(RELATIVE_LOCATION_FILE + name + ".txt")){
			reader.read(data);
			text = String.copyValueOf(data);
		
	}catch(IOException e) {
		e.printStackTrace();
	}
	
		return text;

}
}
