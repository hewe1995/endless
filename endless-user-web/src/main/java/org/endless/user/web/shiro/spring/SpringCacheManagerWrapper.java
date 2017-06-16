/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.endless.user.web.shiro.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;

/**
 * 包装Spring cache抽象
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 13-3-23 上午8:26
 * <p>
 * Version: 1.0
 */
public class SpringCacheManagerWrapper implements CacheManager {

	private org.springframework.cache.CacheManager cacheManager;

	/**
	 * 设置spring cache manager
	 *
	 * @param cacheManager
	 */
	public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		org.springframework.cache.Cache springCache = cacheManager.getCache(name);
		return new SpringCacheWrapper(springCache);
	}

	static class SpringCacheWrapper implements Cache {
		private org.springframework.cache.Cache springCache;

		SpringCacheWrapper(org.springframework.cache.Cache springCache) {
			this.springCache = springCache;
		}

		@Override
		public Object get(Object key) throws CacheException {
			Object value = springCache.get(key);
			if (value instanceof SimpleValueWrapper) {
				return ((SimpleValueWrapper) value).get();
			}
			return value;
		}

		@Override
		public Object put(Object key, Object value) throws CacheException {
			springCache.put(key, value);
			return value;
		}

		@Override
		public Object remove(Object key) throws CacheException {
			springCache.evict(key);
			return null;
		}

		@Override
		public void clear() throws CacheException {
			springCache.clear();
		}

		@SuppressWarnings("unchecked")
		@Override
		public int size() {
			if (RedisOperations.class.isAssignableFrom(springCache.getNativeCache().getClass())) {
				RedisOperations redisOperations = (RedisOperations) springCache.getNativeCache();
				Long size = (Long) redisOperations.execute(new RedisCallback<Long>() {

					@Override
					public Long doInRedis(RedisConnection paramRedisConnection) throws DataAccessException {

						return paramRedisConnection.dbSize();
					}
				});
				return size.intValue();
			} else {
				return 0;
			}

		}

		@SuppressWarnings("unchecked")
		@Override
		public Set keys() {
			if (RedisOperations.class.isAssignableFrom(springCache.getNativeCache().getClass())) {
				RedisOperations redisOperations = (RedisOperations) springCache.getNativeCache();
				return redisOperations.keys("shiro-*");
			} else {
				return null;
			}
		}

		@Override
		public Collection values() {
			Set keys = this.keys();
			if (!(CollectionUtils.isEmpty(keys))) {
				List values = new ArrayList(keys.size());
				for (Object key : keys) {
					Object value = get(key);
					if (value != null)
						values.add(value);
				}
				return Collections.unmodifiableList(values);
			} else {
				return Collections.emptyList();
			}

		}
	}
}
