package com.fj.service.imp;

import java.util.List;

import com.fj.dao.StudentDao;
import com.fj.dao.imp.StudentDaoImpl;
import com.fj.domain.Student;
import com.fj.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	//查询所有学生
	@Override
	public List<Student> findAllStu() {
		// TODO Auto-generated method stub
		studentDao = new StudentDaoImpl();
		return studentDao.findList();
	}
	
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao = new StudentDaoImpl();
		studentDao.addStudent(student);
	}

	@Override
	public void deleteStuById(String sid) {
		// TODO Auto-generated method stub
		studentDao = new StudentDaoImpl();
		studentDao.deleteById(sid);
	}
	
	@Override
	public Student finStuById(String sid) {
		// TODO Auto-generated method stub
		studentDao = new StudentDaoImpl();
		return studentDao.findById(sid);
	}
	
	@Override
	public void modifyStu(Student student) {
		// TODO Auto-generated method stub
		studentDao = new StudentDaoImpl();
		studentDao.update(student);
	}
}
