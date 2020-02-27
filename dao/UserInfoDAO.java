package com.capgemini.airlinereservationsystem.dao;

import com.capgemini.airlinereservationsystem.bean.UserInfoBean;

public interface UserInfoDAO {
	public boolean userAuthentication(String userId, String password);
	public boolean userRegister(UserInfoBean user);
	public  boolean updateUserDetails(String userId, UserInfoBean user);
}
