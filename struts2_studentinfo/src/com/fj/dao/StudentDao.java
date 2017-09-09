package com.fj.dao;

import java.util.List;

import com.fj.domain.Student;

public interface StudentDao {
	//查询所有学生
	public List<Student> findList();
	//添加学生
	public void addStudent(Student student);
	//删除学生
	public void deleteById(String sid);
	//id查询
	public Student findById(String sid);
	//更新
	public void update(Student student);
}
