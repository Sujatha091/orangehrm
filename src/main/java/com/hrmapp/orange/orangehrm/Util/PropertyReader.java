package com.hrmapp.orange.orangehrm.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static Properties readData(){
		File file=new File("././configuration/application.properties");
		Properties prop=new Properties();
		try{
			FileReader fr=new FileReader(file);
			prop.load(fr);

		}
		catch (FileNotFoundException fe){
			fe.printStackTrace();
		}
		catch (IOException io){
			io.printStackTrace();
		}
		return prop;
	}

}
