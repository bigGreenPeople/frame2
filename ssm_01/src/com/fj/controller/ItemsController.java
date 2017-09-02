package com.fj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fj.po.ItemsCustom;
import com.fj.service.ItemsService;
import com.fj.service.imp.ItemsServiceImp;

@Controller
//窄化请求映射
@RequestMapping("/item")
public class ItemsController {
	//注解注入
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
	/* 方法的返回值:void(使用request跳转) String ModelAndView
	 * Converter参数绑定
	 * 方法的形参HttpServletRequest HttpServletResponse等域对象 
	 * 也可以说Model把值放入到Model中
	 * @RequestParam(value="id",required=true)
	 * 上面表示key为id的值传入
	 * required表示此参数一定要有
	 * */
	//跳转到修改界面
	@RequestMapping("/editItem.action")
	public String editItem(Model model,@RequestParam(value="id",required=true) Integer id) throws Exception{
		//service调用方法得到商品对象
		ItemsCustom itemsCustom = iItemsService.findItemById(id);
		//将对象放入到model中
		model.addAttribute("itemsCustom", itemsCustom);
		//通过视图解析器跳转页面
		//请求转向
		//return "redirect:editItem"
		//请求转发
		//return "forword:editItem"
		return "editItem";
	}
	
	//修改商品信息
	/*
	 * method:指定方法只能被get和post访问
	 * */
	@RequestMapping(value="/editItemSubmit.action",method={RequestMethod.GET,RequestMethod.POST})
	public String editItemSubmit(Integer id,ItemsCustom itemsCustom) throws Exception{
		iItemsService.saveItem(id, itemsCustom);
		//跳转到成功界面
		return "success";
	}
}
