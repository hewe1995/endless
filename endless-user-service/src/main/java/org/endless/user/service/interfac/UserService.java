package org.endless.user.service.interfac;

import org.endless.user.domain.Subscriber;

public interface UserService {
	/**
	 * 创建用户
	 * 
	 * @param subscriber
	 * @return
	 */
	int createUser(Subscriber subscriber);

	/**
	 * 通过id查找用户
	 * 
	 * @param id
	 * @return
	 */
	Subscriber getUserInfo(String id);

	/**
	 * 通过邮箱手机号登录名获取用户
	 * 
	 * @param identity
	 * @return
	 */
	Subscriber getUserByIdentity(String identity);
}
