package com.jtest;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jtest.VO.StudentVO;
/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentAction stdAction = new StudentAction();
	private List<StudentVO> stdslist = new ArrayList<>();
	
    public StudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Integer> stdDptRowspan = new HashMap<>();
		Map<String, Integer> stdMarks = new HashMap<>();

		stdslist = getStudentList();
		System.out.println("[StudentController] doGet -> stdslist size: " + stdslist.size());
		request.setAttribute("stdslist", stdslist);
		
		//Department ID
        for (StudentVO stdvo : stdslist) {
            String departmentId = stdvo.getDepartmentId();
            stdDptRowspan.put(departmentId, stdDptRowspan.getOrDefault(departmentId, 0) + 1);
        }
        request.setAttribute("departmentRowspanMap", stdDptRowspan);
        
        
        //Marks
        //Get num of students that marks >= 40 group by departm id;
        Map<String, Long> groupCounts = stdslist.stream()
                .filter(std -> std.getMarks() >= Constants.PASS_MARK)
                .collect(Collectors.groupingBy(StudentVO::getDepartmentId, Collectors.counting()));

        
        //Get num of students group by departm id;
        Map<String, Long> totalGroupCounts = stdslist.stream()
                .collect(Collectors.groupingBy(StudentVO::getDepartmentId, Collectors.counting()));
        
        //Final Calculation
        Map<String, String> passingRate = new HashMap<>();
        for (Map.Entry<String, Long> entry : totalGroupCounts.entrySet()) {
            String key = entry.getKey();           
            double numTotal = (double) entry.getValue();
            double numPass = 0.0;
            if (groupCounts.containsKey(key)) {
            	numPass = (double) groupCounts.get(key);
            }else {
            	passingRate.put(key, formatDouble(0.0));
            }
            System.out.println("[StudentController] numPass: " + numPass);
            System.out.println("[StudentController] numTotal: " + numTotal);
            
            // Perform the calculation, e.g., addition in this case
        	double calculatedValue = (numPass / numTotal) * 100;
            System.out.println("[StudentController] calculatedValue: " + calculatedValue);
            passingRate.put(key, formatDouble(calculatedValue));
            
        }
        
        request.setAttribute("atPercentages", passingRate);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
	
	private static String formatDouble(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(number);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	public List<StudentVO> getStudentList() {
		List<StudentVO> stdlst = stdAction.getStudent();
		stdlst.sort(Comparator.comparing(StudentVO::getDepartmentId).thenComparing(StudentVO::getStudentId));
		return stdlst;
	}

	public List<StudentVO> getStdslist() {
		return stdslist;
	}

	public void setStdslist(List<StudentVO> stdslist) {
		this.stdslist = stdslist;
	}
	
	
}
