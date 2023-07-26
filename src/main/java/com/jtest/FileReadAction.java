package com.jtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileReadAction {
	public List<String> getFile(String filePath){	
		List<String> filelst = new ArrayList<>();
		try (FileReader fileReader = new FileReader(filePath);
	         BufferedReader bufferedReader = new BufferedReader(fileReader)) {	            
	            String line;	            
	            while ((line = bufferedReader.readLine()) != null) {	   
	            	filelst.add(line);
	            }
	            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return filelst;
	}
}
