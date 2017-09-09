package com.fj.dao;

import java.util.List;

import com.fj.domain.Student;

public interface StudentDao {
	//��ѯ����ѧ��
	public List<Student> findList();
	//���ѧ��
	public void addStudent(Student student);
	//ɾ��ѧ��
	public void deleteById(String sid);
	//id��ѯ
	public Student findById(String sid);
	//����
	public void update(Student student);
}
