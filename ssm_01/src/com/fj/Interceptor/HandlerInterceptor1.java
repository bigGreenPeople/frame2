package com.fj.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1 implements HandlerInterceptor {

	//handler执行后
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
	}
	
	//handler执行后modelAndView返回之前
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
	}
	//handler执行前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle");
		return true;
	}

}
