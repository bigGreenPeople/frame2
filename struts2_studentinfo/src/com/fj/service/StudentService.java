package com.fj.service;

import java.util.List;

import com.fj.domain.Student;

public interface StudentService {
	//��ѯ����ѧ��
	public List<Student> findAllStu();
	//���ѧ��
	public void addStudent(Student student);
	//ɾ��ѧ��
	public void deleteStuById(String sid);
	//id��ѯѧ��
	public Student finStuById(String sid);
	//�޸�ѧ��
	public void modifyStu(Student student);
}
