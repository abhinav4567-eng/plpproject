package com.capgemini.airlinereservationsystem.service;

import com.capgemini.airlinereservationsystem.bean.UserInfoBean;
import com.capgemini.airlinereservationsystem.dao.UserInfoDAO;
import com.capgemini.airlinereservationsystem.dao.UserInfoDAOImpl;

public class UserInfoServiceImpl implements UserInfoService{
	private UserInfoDAO userDAO = UserInfoDAOImpl.getUserInfoDAO();

	public static UserInfoService getUserInfoService() {
		return new UserInfoServiceImpl();
	}
	
	@Override
	public boolean userAuthentication(String userId, String password) {
		System.out.println("service - > "+userId+" "+password);
		return userDAO.userAuthentication(userId, password);
	}

	@Override
	public boolean userRegister(UserInfoBean user) {
		return userDAO.userRegister(user);
	}

	@Override
	public boolean updateUserDetails(String userId, UserInfoBean user) {
		return userDAO.updateUserDetails(userId, user);
	}
	
	
}
