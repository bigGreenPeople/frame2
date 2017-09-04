package com.fj.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
//�Զ����쳣������
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		//��ӡ���쳣��Ϣ
		ex.printStackTrace();
		//�����쳣������
		CustomException customException = null;
		//�ж��쳣�Ƿ��������Զ�����쳣
		if(ex instanceof CustomException){
			//�ǵĻ�����ֱ��ת��
			customException = (CustomException) ex;
		}else{
			//�������
			//�����������ʹ���Զ����쳣�����һ��δ֪������쳣
			customException = new CustomException("δ֪����,����ϵͳ����Ա��ϵ!");
		}
		//�����ǵĴ������model��
		ModelAndView modelAndView = new ModelAndView();
		//���쳣�Ĵ�����Ϣ���뵽model
		modelAndView.addObject("message", customException.getMessage());
		//��ת���������
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
