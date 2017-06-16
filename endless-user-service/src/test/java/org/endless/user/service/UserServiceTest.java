package org.endless.user.service;

import org.endless.user.domain.Subscriber;
import org.endless.user.service.interfac.UserService;
import org.endless.util.dao.DaoUtils;
import org.endless.util.dao.PasswordHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-root.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testFind() {
		Subscriber sub = userService.getUserByIdentity("18234527253");
		if (sub != null) {
			System.out.println(sub.getLogin());
		}
	}

	@Test
	public void testSave() {
		Subscriber sub = null;

		sub = new Subscriber();
		sub.setId(DaoUtils.uuid());
		sub.setPhone("18233293963");
		sub.setPasswd("123");
		System.out.println(userService.createUser(sub));
	}

	@Test
	public void testINfo() {
		Subscriber sub = null;
		sub = userService.getUserInfo("4bc160a0-83d5-43b4-b0a1-abf411f5f295");
		System.out.println(sub.toString());
	}

	@Test
	public void testIdentity() {
		Subscriber sub = null;
		sub = userService.getUserByIdentity("18233293969");
		System.out.println(sub.toString());
	}
}
