package com.fj.exception;

//统一的异常处理( 自定义异常类)
public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//异常的信息
	private String message;
	
	//构造方法
	public CustomException(String message) {
		// TODO Auto-generated constructor stub
		//进行异常的初始化
		super(message);
		//赋值给我们的message
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
