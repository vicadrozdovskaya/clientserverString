package by.drozdovskaya.clientstring.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WorkWithFile {

	private static final String RELATIVE_LOCATION_FILE = "recources\\";
	
	public void fileExists(String name) {
		
		if(! new File(RELATIVE_LOCATION_FILE + name + ".txt").exists());{
			File file = new File(RELATIVE_LOCATION_FILE + name + ".txt");
		}
		
	}

	public void writeToFile(String name, String text) {
		this.fileExists(name);
		
		try(FileWriter writer = new FileWriter(RELATIVE_LOCATION_FILE + name + ".txt", true)){
			writer.write(text);
		
	}catch(IOException e) {
		e.printStackTrace();
	}
	


}
}
