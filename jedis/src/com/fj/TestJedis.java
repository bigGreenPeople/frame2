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
	//ʹ�����ӳ�
	@Test
	public void test2(){
/*		//���������ļ�����
		JedisPoolConfig config = new JedisPoolConfig();
		//�������ӳص������ļ�
		//�����������
		config.setMaxTotal(50);
		//����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����
        config.setMaxIdle(5);
        
        //�õ����ӳض���
        JedisPool pool = new JedisPool(config,"192.168.108.130", 6379);
*/        
        //�õ�����
        Jedis jedis = JedisUtils.getJedis();
        //��������
		jedis.auth("123");
		String name = jedis.get("name");
		System.out.println(name);
	}
}
