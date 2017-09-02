package com.fj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fj.po.ItemsCustom;
import com.fj.service.ItemsService;
import com.fj.service.imp.ItemsServiceImp;

@Controller
public class ItemsController {
	//×¢½â×¢Èë
	@Autowired
	private ItemsService iItemsService;
	
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems() throws Exception{
		
		List<ItemsCustom> list = iItemsService.findItemsList(null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", list);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
}
