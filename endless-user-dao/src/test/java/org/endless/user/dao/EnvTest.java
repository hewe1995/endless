package org.endless.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.endless.user.dao.interfac.SubscriberDao;
import org.endless.user.domain.Subscriber;
import org.endless.util.dao.DaoUtils;
import org.endless.util.dao.PasswordHelper;
import org.endless.util.test.TestData;
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
	public void testUserAdd() {
		Subscriber sb = new Subscriber();
		List<Subscriber> list = new ArrayList<Subscriber>();
		sb.setEmail("235");
		sb.setId(DaoUtils.uuid());
		sb.setLogin("admin");
		sb.setPasswd("123");
		sb.setPhone("1353333");
		sb.setSalt(PasswordHelper.encryptSalt(sb.getLogin()));
		sb.setPasswd(PasswordHelper.encryptPassword(sb.getPasswd(), sb.getSalt()));
		list.add(sb);
		int id = sDao.insertBatch(list);
		System.out.println(id);
	}

	@Test
	public void testUserAddBatch() {
		Subscriber sb = new Subscriber();
		List<Subscriber> list = new ArrayList<Subscriber>();
		for (int j = 10000; j > 0; j--) {
			for (int i = 10; i > 0; i--) {
				sb = new Subscriber();
				sb.setEmail(TestData.generateEmail());
				sb.setId(DaoUtils.uuid());
				sb.setLogin(TestData.generaterLogin());
				sb.setPhone(TestData.generatephone());
				sb.setSalt(PasswordHelper.encryptSalt(null));
				sb.setPasswd(PasswordHelper.encryptPassword(sb.getLogin(), sb.getSalt()));
				list.add(sb);
			}
			int id = sDao.insertBatch(list);
			System.out.println(id);
			list.clear();
		}
	}

	@Test
	public void testGeneratorChar() {
		System.out.println(TestData.generaterLogin());
	}

	@Test
	public void testBatch() {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 10000; i > 0; i--) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					Subscriber sb = new Subscriber();
					List<Subscriber> list = new ArrayList<Subscriber>();
					for (int i = 10; i > 0; i--) {
						sb = new Subscriber();
						sb.setEmail(TestData.generateEmail());
						sb.setId(DaoUtils.uuid());
						sb.setLogin(TestData.generaterLogin());
						sb.setPhone(TestData.generatephone());
						sb.setSalt(PasswordHelper.encryptSalt(null));
						sb.setPasswd(PasswordHelper.encryptPassword(sb.getLogin(), sb.getSalt()));
						list.add(sb);
					}
					int id = sDao.insertBatch(list);
				}
			});
		}
		service.shutdown();
		while (!service.isTerminated())
			;
	}

	@Test
	public void testFindByIdentity() {
		Subscriber sb = sDao.selectByidentity("14207641484");
		if (sb != null) {
			System.out.println(sb.getLogin());
		}
	}
}
