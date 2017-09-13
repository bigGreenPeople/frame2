package com.fj.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	//����һ�����ӳض���
	private final static JedisPool POOL;
	
	//�õ����ӳ�
	static{
		//���������ļ�����
		JedisPoolConfig config = new JedisPoolConfig();
		//�������ӳص������ļ�
		//�����������
		config.setMaxTotal(50);
		//����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����
        config.setMaxIdle(5);
        
        //�õ����ӳض���
        POOL = new JedisPool(config,"192.168.108.130", 6379);
	}
	
	/**
	 * �õ�����
	 */
	public static Jedis getJedis(){
		return POOL.getResource();
	}
}
