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
	//定义Student对象
	private Student student = new Student();
	
	//添加的Action
	public String add() throws Exception {
		// TODO Auto-generated method stub
		studentService = new StudentServiceImpl();
		studentService.addStudent(student);
		return "tolist";
	}
	
	//查询所有学生的action
	public String findAllStu() throws Exception {
		// TODO Auto-generated method stub
		studentService = new StudentServiceImpl();
		
		List<Student> list = studentService.findAllStu();
		//得到域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		
		return "stuList";
	}
	
	//删除
	public String delete() throws Exception{
		studentService = new StudentServiceImpl();
		studentService.deleteStuById(student.getSid());
		return "tolist";
	}
	
	//到修改页面
	public String toModify(){
		//ID查询学生
		studentService = new StudentServiceImpl();
		Student stu = studentService.finStuById(student.getSid());
		if(stu!=null){
			//得到域对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("stu", stu);
		}
		return "toModify";
	}
	
	//修改 
	public String modify(){
		studentService = new StudentServiceImpl();
		studentService.modifyStu(student);
		return "tolist";
	}
	
	//查询
	public String findStuById(){
		studentService = new StudentServiceImpl();
		
		//查询出的用户放入到list中
		List<Student> list = new ArrayList<Student>();
		Student stu = studentService.finStuById(student.getSid());
		list.add(stu);
		//得到域对象
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
