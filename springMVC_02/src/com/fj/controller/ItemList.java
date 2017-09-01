package com.fj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fj.pojo.Items;
//ָ������Ϊ��˿�����
@Controller
public class ItemList {
	@RequestMapping("/queryItem.action")
	public ModelAndView queryItem() {
		// ��Ʒ�б�
		List<Items> itemsList = new ArrayList<Items>();

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

		// ����modelAndView׼��������ݡ�������ͼ
		ModelAndView modelAndView = new ModelAndView();

		// �������
		modelAndView.addObject("itemsList", itemsList);
		// ��ͼ
		modelAndView.setViewName("itemList");

		return modelAndView;
	}
}
