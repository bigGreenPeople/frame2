package com.fj.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
//自定义异常处理器
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		//打印出异常信息
		ex.printStackTrace();
		//创建异常的引用
		CustomException customException = null;
		//判断异常是否是我们自定义的异常
		if(ex instanceof CustomException){
			//是的话我们直接转换
			customException = (CustomException) ex;
		}else{
			//如果不是
			//如果不是我们使用自定义异常构造出一个未知错误的异常
			customException = new CustomException("未知错误,请与系统管理员联系!");
		}
		//将我们的错误放入model中
		ModelAndView modelAndView = new ModelAndView();
		//将异常的错误信息放入到model
		modelAndView.addObject("message", customException.getMessage());
		//跳转到错误界面
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
