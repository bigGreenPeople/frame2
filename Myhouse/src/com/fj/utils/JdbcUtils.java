package com.fj.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//����һ�����ӳ�
	public static ComboPooledDataSource cds = new ComboPooledDataSource(); 
	//���������
	//public static Connection ct = null;
	//����ĳ��̰߳�ȫ��
	public static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	//�õ�һ������
	public static Connection getConnection() throws SQLException{
		//�������������
		
		Connection ct = threadLocal.get();
		if(ct!=null) return ct;		
		else return cds.getConnection();
	}
	//�õ�һ������Դ
	public static ComboPooledDataSource getCds() {
		return cds;
	}
	
	//��������
	public static void beginTransaction() throws SQLException{
		//�õ�thread���������
		Connection ct = threadLocal.get();
		//�ж������Ƿ���
		if(ct!=null) throw new RuntimeException("����!�����ѿ��� ");
		ct = getConnection();
		ct.setAutoCommit(false);
		
		//�����ӷ���
		threadLocal.set(ct);
	}
	
	
	//�ύ����
	public static void commitTransaction() throws SQLException{
		//�õ�thread���������
		Connection ct = threadLocal.get();
		
		//�ж������Ƿ���
		if(ct==null) throw new RuntimeException("����!����δ���� ");
		ct.commit();
		ct.close();
		//��threadLocal����������Ƴ�
		threadLocal.remove();
	}
		
	//�ع�����
	public static void rollbackTransaction() throws SQLException{
		//�õ�thread���������
		Connection ct = threadLocal.get();
		//�ж������Ƿ���
		if(ct==null) throw new RuntimeException("����!����δ���� ");
		ct.rollback();
		ct.close();
		//��threadLocal����������Ƴ�
		threadLocal.remove();
	}
	
	//�����ͷ�����	
	public static void releaseConnection(Connection connection) throws SQLException{
		//���������Ļ��Ͳ��ͷ� ������Ǿ��ͷ�
		//�õ�thread���������
		Connection ct = threadLocal.get();
		
		//���ct��Ϊnull˵��������
		if(ct==null){
			connection.close();
		}
		//ct��Ϊnullʱ����Ӧ��ȥ�ж������������ǲ���ͬһ������ 
		//�����˵�����Ҫ�ͷŵ���������������ӾͲ�ȥ�ͷ���
		if(ct != connection){
			connection.close();
		}
	}
}
