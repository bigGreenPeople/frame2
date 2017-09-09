package com.fj.service;

import java.util.List;

import com.fj.domain.Student;

public interface StudentService {
	//查询所有学生
	public List<Student> findAllStu();
	//添加学生
	public void addStudent(Student student);
	//删除学生
	public void deleteStuById(String sid);
	//id查询学生
	public Student finStuById(String sid);
	//修改学生
	public void modifyStu(Student student);
}
