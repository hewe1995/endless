package org.endless.user.web.shiro.cache;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache implements Cache {

	private org.springframework.cache.Cache springCache;
	private RedisTemplate redisTemplate;

	public RedisCache(org.springframework.cache.Cache springCache) {
		this.springCache = springCache;
	}

	@Override
	public Object get(Object key) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(Object key, Object value) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(Object key) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}

}
