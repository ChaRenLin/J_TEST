package com.jtest;
import com.jtest.VO.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginAction {
	private UserVO usrVO = new UserVO();
	private FileReadAction fileAction = new FileReadAction();
	
	public List<UserVO> getUserLoginInfo() {
		String fileName = Constants.USER_DETAILS_FILE_PATH;
		List<UserVO> usrList = new ArrayList<UserVO>();		
		List<String> filelst = fileAction.getFile(fileName);
		
		if(filelst.size() > 0) {
			for(String filestr : filelst) {
				usrVO = new UserVO();
	        	String name = filestr.split(Constants.COMMA_EXPRESSION)[0];
	        	String pass = filestr.split(Constants.COMMA_EXPRESSION)[1];
	        	System.out.println("[LoginAction] getUserLoginInfo -> name: " + name);
	        	System.out.println("[LoginAction] getUserLoginInfo -> pass: " + pass);
	        	usrVO.setUserName(name);
	        	usrVO.setUserPassword(pass);
	        	usrList.add(usrVO);
			}
		}		
		return usrList;
	}
 
}
