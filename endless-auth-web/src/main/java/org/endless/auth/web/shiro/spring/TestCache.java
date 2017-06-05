package org.endless.auth.web.shiro.spring;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class TestCache implements CacheManager {

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	static class SpringCacheWrapper implements Cache {

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
}
