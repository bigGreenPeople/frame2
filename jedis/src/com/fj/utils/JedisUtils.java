package com.fj.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	//定义一个连接池对象
	private final static JedisPool POOL;
	
	//得到连接池
	static{
		//创建配置文件对象
		JedisPoolConfig config = new JedisPoolConfig();
		//设置连接池的配置文件
		//设置最大连接
		config.setMaxTotal(50);
		//控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(5);
        
        //得到连接池对象
        POOL = new JedisPool(config,"192.168.108.130", 6379);
	}
	
	/**
	 * 得到连接
	 */
	public static Jedis getJedis(){
		return POOL.getResource();
	}
}
