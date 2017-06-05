package org.endless.auth.service;

import org.endless.auth.service.interfac.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-root.xml" })
public class EnvTest {

	@Autowired
	private ClientService clientService;

	@Test
	public void testCl() {
		clientService.findByClientId("sf");
	}

	// @Autowired
	// private RedisTemplate<String, String> template;
	// @Autowired
	// private CacheManager manager;
	// // inject the template as ListOperations
	// @Resource(name = "redisTemplate")
	// private ListOperations<String, String> listOps;
	// @Autowired
	// private ClientDao clientDao;
	//
	// public void addLink(String userId, URL url) {
	// listOps.leftPush(userId, url.toExternalForm());
	// }
	//
	// @Test
	// public void test11() {
	// listOps.leftPush("eee", "aaaa");
	// listOps.leftPush("eee", "adf");
	// listOps.leftPush("eee", "dfsae");
	// System.out.println("sdafg");
	// }
	//
	// @Test
	// public void testcache() {
	// Set<String> lsit = (Set<String>) manager.getCacheNames();
	// for (String str : lsit) {
	// System.out.println(str);
	// }
	// Cache cache = manager.getCache("hewe");
	// cache.put("dasf", "dfa");
	// cache.put("thisisca", "fdsafad");
	// // cache.evict("thisisca");
	// }
	//
	// @Test
	// public void testFind() {
	// Client client = clientDao.selectByClientId("dfadf");
	// System.out.println(client.getName());
	// }
}
