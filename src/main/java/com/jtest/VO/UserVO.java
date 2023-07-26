package com.jtest.VO;

public class UserVO {
	private String userName;
	private String userPassword;
	
	// Constructor
    public UserVO(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
    
    public UserVO() {
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
