package com.fj.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Student;
import com.fj.service.StudentService;
import com.fj.service.imp.StudentServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private StudentService studentService;
	//����Student����
	private Student student = new Student();
	
	//��ӵ�Action
	public String add() throws Exception {
		// TODO Auto-generated method stub
		studentService = new StudentServiceImpl();
		studentService.addStudent(student);
		return "tolist";
	}
	
	//��ѯ����ѧ����action
	public String findAllStu() throws Exception {
		// TODO Auto-generated method stub
		studentService = new StudentServiceImpl();
		
		List<Student> list = studentService.findAllStu();
		//�õ������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		
		return "stuList";
	}
	
	//ɾ��
	public String delete() throws Exception{
		studentService = new StudentServiceImpl();
		studentService.deleteStuById(student.getSid());
		return "tolist";
	}
	
	//���޸�ҳ��
	public String toModify(){
		//ID��ѯѧ��
		studentService = new StudentServiceImpl();
		Student stu = studentService.finStuById(student.getSid());
		if(stu!=null){
			//�õ������
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("stu", stu);
		}
		return "toModify";
	}
	
	//�޸� 
	public String modify(){
		studentService = new StudentServiceImpl();
		studentService.modifyStu(student);
		return "tolist";
	}
	
	//��ѯ
	public String findStuById(){
		studentService = new StudentServiceImpl();
		
		//��ѯ�����û����뵽list��
		List<Student> list = new ArrayList<Student>();
		Student stu = studentService.finStuById(student.getSid());
		list.add(stu);
		//�õ������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		
		return "stuList";
	}

	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
}
