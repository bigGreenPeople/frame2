package com.fj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fj.po.Items;
import com.fj.po.ItemsCustom;
@Controller
public class JsonController {
	//�������ǵ�json����
	@RequestMapping("/editItemSubmit_RequestJson.action")
	public @ResponseBody ItemsCustom editItemSubmit_RequestJson(@RequestBody ItemsCustom itemsCustom){
		System.out.println(itemsCustom);
		return itemsCustom;
	}
}
