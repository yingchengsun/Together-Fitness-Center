package com.xdsc.service.xsgl_system;

public interface LoginManager {

	public abstract boolean userLogin(String username, String password);

	public abstract boolean studentConfirm(String userNum);

	public abstract boolean teacherConfirm(String userNum);

	public abstract boolean parentConfirm(String userNum);

}