/**
 * EhcacheUtil.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheUtil {
	//缓存管理器
	static CacheManager cacheManager;
	
	static
	{
	    String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		cacheManager = CacheManager.create(path + "ehcache.xml");
	}
	/**
	 * 插入一个对象
	 * @param key
	 * @param value
	 */
	public void putCache(String key,Object value){		
		// 获取ehcache配置文件中的一个cache
		Cache sample = cacheManager.getCache("com.shdatabank.puruanCache");
		// 添加数据到缓存中
		Element element = new Element(key, value);
		sample.put(element);
	}
	/**
	 * 根据key获取一个对象
	 * @param key
	 * @return
	 */
	public Object getCache(String key){
		// 获取ehcache配置文件中的一个cache
		Cache sample = cacheManager.getCache("com.shdatabank.puruanCache");
		Element element = sample.get(key);		
		return element.getKey();
	}
	/**
	 * 删除一个对象
	 *
	 */
	public void deleteCache(String key){
		Cache sample = cacheManager.getCache("com.shdatabank.puruanCache");
		sample.remove(key);
	}
}
