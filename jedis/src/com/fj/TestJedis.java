package com.fj;

import org.junit.Test;

import com.fj.utils.JedisUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestJedis {
	@Test
	public void test(){
		Jedis jedis = new Jedis("192.168.108.130", 6379);
		jedis.auth("123");
		
		String name = jedis.get("name");
		System.out.println(name);
	}
	//使用连接池
	@Test
	public void test2(){
/*		//创建配置文件对象
		JedisPoolConfig config = new JedisPoolConfig();
		//设置连接池的配置文件
		//设置最大连接
		config.setMaxTotal(50);
		//控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(5);
        
        //得到连接池对象
        JedisPool pool = new JedisPool(config,"192.168.108.130", 6379);
*/        
        //得到连接
        Jedis jedis = JedisUtils.getJedis();
        //设置密码
		jedis.auth("123");
		String name = jedis.get("name");
		System.out.println(name);
	}
}
