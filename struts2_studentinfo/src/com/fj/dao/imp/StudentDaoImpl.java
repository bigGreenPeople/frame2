package com.fj.dao.imp;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fj.dao.StudentDao;
import com.fj.domain.Student;
import com.fj.utils.SQLHelper;

public class StudentDaoImpl implements StudentDao {

	//查询所有学生
		@Override
		public List<Student> findList() {
			// TODO Auto-generated method stub
			//定义好list
			ArrayList<Student> stuList = new ArrayList<Student>();
			String sql = "SELECT * FROM student";
			
			ArrayList<Object[]> list = SQLHelper.executeQuery2(sql, null);
			if(list!=null && list.size()>0){
				//二次封装
				for (Object[] ob : list) {
					Student student = new Student();
					
					student.setSid(ob[0].toString());
					student.setSname(ob[1].toString());
					student.setSsex(ob[2].toString());
					//转换Date
					Date date = (Date)ob[3];
					java.util.Date newDate = new java.util.Date(date.getTime());
					student.setSbirthday(newDate);
					student.setSmajor(ob[4]+"");
					student.setSscore(Integer.parseInt(ob[5].toString()));
					student.setStel(ob[6].toString());
					//添加到list
					stuList.add(student);
				}
				
			}
			return stuList;
		}
		
		@Override
		public void addStudent(Student student) {
			// TODO Auto-generated method stub
			String sql = "INSERT INTO student VALUES(?,?,?,?,?,?,?)";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			String date = simpleDateFormat.format(student.getSbirthday());
			String[] parameters = {
					student.getSid(),student.getSname(),student.getSsex(),date,student.getSmajor(),student.getSscore()+"",student.getStel()
			};
			SQLHelper.executeUpdate(sql, parameters);
		}
		
		@Override
		public void deleteById(String sid) {
			// TODO Auto-generated method stub
			String sql = "DELETE FROM student WHERE sid=?";
			String[] parameters = {sid};
			SQLHelper.executeUpdate(sql, parameters);
		}
		
		@Override
		public Student findById(String sid) {
			// TODO Auto-generated method stub
			String sql = "SELECT * FROM student WHERE sid=?";
			String[] parameters = {sid};
			ArrayList<Object[]> list = SQLHelper.executeQuery2(sql, parameters);
			if(list!=null && list.size()>0){
				Student student = new Student();
				
				Object[] ob = list.get(0);
				
				student.setSid(ob[0].toString());
				student.setSname(ob[1].toString());
				student.setSsex(ob[2].toString());
				//转换Date
				Date date = (Date)ob[3];
				java.util.Date newDate = new java.util.Date(date.getTime());
				student.setSbirthday(newDate);
				student.setSmajor(ob[4]+"");
				student.setSscore(Integer.parseInt(ob[5].toString()));
				student.setStel(ob[6].toString());
				
				return student;
			}
			return null;
		}
		
		@Override
		public void update(Student student) {
			// TODO Auto-generated method stub
			String sql = "UPDATE student SET sname=?,ssex=?,sbirthday=?,smajor=?,sscore=?,stel=? WHERE sid=?";
			//转换日期值
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			String date = simpleDateFormat.format(student.getSbirthday());
			String[] parameters = {
					student.getSname(),student.getSsex(),date,student.getSmajor(),student.getSscore()+"",student.getStel(),student.getSid()
			};
			SQLHelper.executeUpdate(sql, parameters);
		}
}
