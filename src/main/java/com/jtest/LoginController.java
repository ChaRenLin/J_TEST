package com.jtest;
import com.jtest.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jtest.VO.StudentVO;
import com.jtest.VO.UserVO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	private LoginAction loginAction = new LoginAction();
	private StudentController stdCtrller = new StudentController();
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserVO userData = (UserVO) request.getSession().getAttribute("usrVO"); 
        String name = userData.getUserName();
        String password = userData.getUserPassword();
        
        List<UserVO> usrList = loginAction.getUserLoginInfo();
        usrList.forEach(usr -> System.out.println("User: " + usr.getUserName() + ", Password: " + usr.getUserPassword()));
        boolean loginStatus = usrList.stream().anyMatch(usr -> usr.getUserName().equals(name) && usr.getUserPassword().equals(password));
        System.out.println("[LoginController] doGet -> loginStatus: " + loginStatus);
        if(!loginStatus) {      	
        	request.setAttribute("FailedToLogin", Constants.FAILED_TO_LOGIN);
        	request.getRequestDispatcher("/Main").forward(request, response);
        }	
        //get Student list
        request.setAttribute("userName", name);
        request.getRequestDispatcher("/StudentController").forward(request, response);
       
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
