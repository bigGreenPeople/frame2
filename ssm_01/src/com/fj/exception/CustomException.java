package com.fj.exception;

//ͳһ���쳣����( �Զ����쳣��)
public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//�쳣����Ϣ
	private String message;
	
	//���췽��
	public CustomException(String message) {
		// TODO Auto-generated constructor stub
		//�����쳣�ĳ�ʼ��
		super(message);
		//��ֵ�����ǵ�message
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
