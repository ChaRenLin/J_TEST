<%@ page import="com.jtest.VO.UserVO" %>
<%@ page contentType="text/html" %>
<%
    // Receiving the input value from the client
    String name = request.getParameter("Name");
	String password = request.getParameter("Password");
    
    UserVO usrVO = new UserVO(name, password);
    request.getSession().setAttribute("usrVO", usrVO);
    response.sendRedirect("LoginController");
%>
