package com.fj.common.web;

import javax.servlet.http.HttpServletResponse;

/**
 * 用于web项目返回数据
 * @author bigGreenPeople
 *
 */
public class ResponseUtils {
	//发送内容
	public static void render(HttpServletResponse response,String contentType,String text){
		response.setContentType(contentType);
		try {
			response.getWriter().write(text);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	//发送json数据
	public static void renderJson(HttpServletResponse response,String text){
		render(response, "application/json;charset=UTF-8", text);
	}
	//发送xml数据
	public static void renderXml(HttpServletResponse response,String text){
		render(response, "text/xml;charset=UTF-8", text);
	}
	//发送text数据
	public static void renderText(HttpServletResponse response,String text){
		render(response, "text/plain;charset=UTF-8", text);
	}
}
