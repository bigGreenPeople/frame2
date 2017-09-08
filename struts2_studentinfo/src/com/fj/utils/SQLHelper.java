package com.fj.utils;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
public class SQLHelper {
	
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static CallableStatement cs=null;
	
	private static String username;
	private static String password;
	private static String driver;
	private static String url;
	
	static{
		Properties pp = new Properties();
		InputStream fis=null;
		try {
			//fis=new FileInputStream("src/dbinfo.properties");
			fis=SQLHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fis);
			
			username =(String) pp.getProperty("username");
			password =(String) pp.getProperty("password");
			driver =(String) pp.getProperty("driver");
			url =(String) pp.getProperty("url");
			
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(fis!=null)
			{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fis=null;
			}
		}
		
	}
	
	//�������ݿ�Ĵ洢����
	public static void executeProcedure(String sql,String [] parameters)
	{
		try {
			ct=DriverManager.getConnection(url,username,password);
			cs=ct.prepareCall(sql);
			if(parameters!=null)
			{
				for(int i=0;i<parameters.length;i++)
				{
					cs.setString(i+1, parameters[i]);
				}
			}
			cs.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
//	�����ݿ�ĸ��²���
	public static void executeUpdate(String sql,String[] parameters){
		try {
			ct = DriverManager.getConnection(url, username, password);
			ps=ct.prepareStatement(sql);
			if(parameters!=null)
			{
				for(int i=0;i<parameters.length;i++)
				{
					ps.setString(i+1, parameters[i]);
				}
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs, ps, ct);
		}
	}
	
	
	
	public static void executeUpdate2(String[] sql,String[][] parameters){
		try {
			ct = DriverManager.getConnection(url, username, password);
			ct.setAutoCommit(false);
			//�������ǰ�sql�������������
			//ps=ct.prepareStatement(sql);
			if(parameters!=null)
			{
				for(int i=0;i<sql.length;i++)
				{
					ps=ct.prepareStatement(sql[i]);
					for(int j=0;j<parameters[i].length;j++)
					{
						ps.setString(j+1, parameters[i][j]);
					}
					ps.executeUpdate();
				}
				
			}else{
				for(int i=0;i<sql.length;i++)
				{
					ps=ct.prepareStatement(sql[i]);
					ps.executeUpdate();
				}
			}
			ct.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, ps, ct);
		}
	}
	
	public static ArrayList<Object[]> executeQuery2(String sql,String[] parameters){	
		ArrayList<Object[]> al=null;
		try {
			ct = DriverManager.getConnection(url, username, password);
			ps=ct.prepareStatement(sql);
			if(parameters!=null)
			{
				for(int i=0;i<parameters.length;i++)
				{
					ps.setString(i+1, parameters[i]);
				}
			}
			rs=ps.executeQuery();
			
			al=new ArrayList<Object[]>();
			ResultSetMetaData rsmd=rs.getMetaData();
//			�õ��ж���������
			int column=rsmd.getColumnCount();
			
			while(rs.next()){
//				����һ���������飬��ʾһ������
				Object[] ob=new Object[column];
				for(int i=1;i<=column;i++){
					ob[i-1]=rs.getObject(i);
				}
				al.add(ob);
			}
			return al;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(rs, ps, ct);
		}
		return al;
	}
	
//	�����ݿ�Ĳ�ѯ
	public static ResultSet executeQuery(String sql,String[] parameters){
		
		try {
			ct = DriverManager.getConnection(url, username, password);
			ps=ct.prepareStatement(sql);
			if(parameters!=null)
			{
				for(int i=0;i<parameters.length;i++)
				{
					ps.setString(i+1, parameters[i]);
				}
			}
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�������ǲ���ȥ�ͷ�rs������޷�ʹ��rs�����صĽ������
		}
		
		return rs;
		
	}
	
public static Connection getCt() {
		return ct;
	}

	public static void setCt(Connection ct) {
		SQLHelper.ct = ct;
	}

	public static PreparedStatement getPs() {
		return ps;
	}

	public static void setPs(PreparedStatement ps) {
		SQLHelper.ps = ps;
	}

	public static ResultSet getRs() {
		return rs;
	}

	public static void setRs(ResultSet rs) {
		SQLHelper.rs = rs;
	}

	public static CallableStatement getCs() {
		return cs;
	}

	public static void setCs(CallableStatement cs) {
		SQLHelper.cs = cs;
	}

	//	�ر���Դ�ĺ���
	public static void close(ResultSet rs,Statement ps,Connection ct){
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
		}
		if(ct!=null)
		{
			try{
				ct.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			ct=null;
		}

		if(ps!=null)
		{
			try{
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			ps=null;
		}
	}

}
