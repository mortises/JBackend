package com.mortise.ssm.service;

import java.util.List;

import com.mortise.ssm.entity.User;

public interface UserService {

	/**
	 * pager getter
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<User> getUserList(int offset, int limit);
	 
}
