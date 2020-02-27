package com.capgemini.airlinereservationsystem.service;

import com.capgemini.airlinereservationsystem.bean.UserInfoBean;

public interface UserInfoService {
	public boolean userAuthentication(String userId, String password);
	public boolean userRegister(UserInfoBean user);
	public  boolean updateUserDetails(String userId, UserInfoBean user);
}
