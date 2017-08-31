package com.fj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.fj.pojo.Items;

public class ItemList2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��Ʒ�б�
		List<Items> itemsList = new ArrayList<Items>();
		System.out.println("ItemList2");
		Items items_1 = new Items();
		items_1.setName("����ʼǱ�");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 ����ʼǱ����ԣ�");
		
		Items items_2 = new Items();
		items_2.setName("ƻ���ֻ�");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6ƻ���ֻ���");
		
		itemsList.add(items_1);
		itemsList.add(items_2);

		request.setAttribute("itemsList", itemsList);
		
		request.getRequestDispatcher("/itemList.jsp").forward(request, response);
	}



}
