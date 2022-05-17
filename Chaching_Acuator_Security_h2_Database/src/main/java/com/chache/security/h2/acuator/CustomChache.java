package com.chache.security.h2.acuator;






import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import net.sf.ehcache.config.CacheConfiguration;


@Configuration
@EnableCaching
public class CustomChache extends CachingConfigurerSupport{
	
	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager()
	{
		CacheConfiguration tensecondcache=new CacheConfiguration();
		tensecondcache.setName("ten-second-cache");
		tensecondcache.setMemoryStoreEvictionPolicy("LRU");
		tensecondcache.setMaxEntriesLocalHeap(1000);
		tensecondcache.internalSetTimeToLive(5);
		tensecondcache.setTimeToLiveSeconds(5);
		
		CacheConfiguration twentysecond=new CacheConfiguration();
		twentysecond.setName("twenty-second-cache");
		twentysecond.setMemoryStoreEvictionPolicy("LRU");
		twentysecond.setMaxEntriesLocalHeap(1000);
		twentysecond.setTimeToLiveSeconds(20);
		
		net.sf.ehcache.config.Configuration config=new net.sf.ehcache.config.Configuration();
		config.addCache(twentysecond);
		config.addCache(tensecondcache);
		return net.sf.ehcache.CacheManager.newInstance(config); 
		
	}
	
	


	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}

	
	
	
}
