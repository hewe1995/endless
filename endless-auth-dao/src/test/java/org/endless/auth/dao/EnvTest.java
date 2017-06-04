package org.endless.auth.dao;

import org.endless.auth.dao.interfac.ClientDao;
import org.endless.auth.domain.Client;
import org.endless.user.dao.interfac.SubscriberDao;
import org.endless.user.domain.Subscriber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-root.xml" })
public class EnvTest {

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private SubscriberDao subDao;

	@Test
	public void testAdd() {
		Client client = new Client();
		client.setClientId("dfadf");
		client.setName("name");
		client.setClientSecret("secret");
		clientDao.insert(client);
	}

	@Test
	public void testFind() {
		Client client = clientDao.selectByClientId("dfadf");
		Subscriber sub = subDao.selectByidentity("1");
	}
}
