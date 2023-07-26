package com.jtest;

import java.util.ArrayList;
import java.util.List;

import com.jtest.VO.StudentVO;

public class StudentAction {
	private StudentVO stdVO = new StudentVO();
	private FileReadAction fileAction = new FileReadAction();
	
	public List<StudentVO> getStudent() {
		String fileName = Constants.STUDENT_DETAILS_FILE_PATH;
		List<String> filelst = fileAction.getFile(fileName);
		List<StudentVO> stdlst = new ArrayList<>();		
		
		if(filelst.size() > 0) {
			for(String filestr : filelst) {
				stdVO = new StudentVO();
				String dptId = filestr.split(Constants.COMMA_EXPRESSION)[0];
	        	String stdid = filestr.split(Constants.COMMA_EXPRESSION)[1];
	        	String stdname = filestr.split(Constants.COMMA_EXPRESSION)[2];
	        	String stdmarks = filestr.split(Constants.COMMA_EXPRESSION)[3];
	        	System.out.println("[StudentAction] getStudent -> dptId: " + dptId);
	        	System.out.println("[StudentAction] getStudent -> stdid: " + stdid);
	        	System.out.println("[StudentAction] getStudent -> stdname: " + stdname);
	        	System.out.println("[StudentAction] getStudent -> stdmarks: " + stdmarks);
	        	stdVO.setDepartmentId(dptId);
	        	stdVO.setStudentId(stdid);
	        	stdVO.setStudentName(stdname);
	        	stdVO.setMarks(Double. parseDouble(stdmarks));
	        	stdlst.add(stdVO);
			}
		}		
		return stdlst;		
	}
}
