package org.endless.user.dao;

import org.endless.user.dao.interfac.SubscriberDao;
import org.endless.user.domain.Subscriber;
import org.endless.util.dao.DaoUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-root.xml" })
public class EnvTest {
	@Autowired
	private SubscriberDao sDao;

	@Test
	public void testEnv() {
		Subscriber sb = new Subscriber();
		sb.setEmail("235");
		sb.setId(DaoUtils.uuid());
		sb.setLogin("admin");
		sb.setPasswd("123");
		sb.setPhone("1353333");
		int id = sDao.insert(sb);
		System.out.println(id);
	}

	@Test
	public void testInteger() {
		int ii = 11111;
		int jj = 11111;
		Integer i = ii;
		Integer j = jj;
		System.out.println(ii == jj);
		System.out.println(i.equals(j));
	}
}
