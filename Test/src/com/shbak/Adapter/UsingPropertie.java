package com.shbak.Adapter;

import java.io.*;
import java.util.Properties;

public class UsingPropertie {
	static public void main(String args[]){
		FileIO f = new FileProperties();
		try{
			f.readFromFile("C:\\workspace\\Test\\bin\\com\\shbak\\Adapter\\file.txt");
			f.setValue("year", "2004");
			f.setValue("month", "4");
			f.setValue("day", "21");
			f.writeToFile("newfile.txt");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}

class Adapter{
	
}

class FileProperties implements FileIO{
	Properties p = new Properties();

	FileProperties(){
	}
	
	public void readFromFile(String filename) throws IOException{
		InputStream is = new FileInputStream(filename);
		this.p.load(is);		
	};
	
	public void writeToFile(String filename) throws IOException{
		OutputStream os = new FileOutputStream(filename);
		this.p.store(os, "Comment");
	};
	
	public void setValue(String key, String value){
		this.p.setProperty(key, value);		
	};
	
	public String getValue(String key){
		return this.p.getProperty(key);
	};
}

interface FileIO{
	public void readFromFile(String filename) throws IOException;
	public void writeToFile(String filename) throws IOException;
	public void setValue(String key, String value);
	public String getValue(String key);
}