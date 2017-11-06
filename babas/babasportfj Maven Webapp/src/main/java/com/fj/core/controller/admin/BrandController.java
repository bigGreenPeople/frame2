package com.fj.core.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;

import com.fj.core.bean.Brand;
import com.fj.core.service.product.BrandService;

@Controller
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/brand/list.do")
	public String list(String name,Integer isDisplay,Integer pageNo,ModelMap model){
		StringBuilder params = new StringBuilder();
		Brand brand = new Brand();
		//如果传进来的参数不为空
		if(StringUtils.isNotBlank(name)){
			brand.setName(name);
			params.append("name=").append(name);
		}
		//判断选择是不是
		if(null != isDisplay){
			brand.setIsDisplay(isDisplay);
			params.append("&").append("isDisplay=").append(isDisplay);
		}else{
			brand.setIsDisplay(1);
			params.append("&").append("isDisplay=").append(1);
		}
		
		//如果页号是null或者小于1置为1
		brand.setPageNo(Pagination.cpn(pageNo));
		//设置页数
		brand.setPageSize(5);
		
		//查询
		Pagination pagination = brandService.getBrandListWithPage(brand);
		String url = "/brand/list.do";
		pagination.pageView(url, params.toString());
		//放入
		model.addAttribute("pagination",pagination);
		//数据回显
		model.addAttribute("name",name);
		model.addAttribute("isDisplay",isDisplay);
		
		return "brand/list";
	}
	
	//跳转品牌添加页面
	@RequestMapping("/brand/toAdd.do")
	public String toAdd(){
		return "brand/add";
	}
	
	//添加品牌
	@RequestMapping(value = "/brand/add.do")
	public String add(Brand brand){
		//添加开始
		brandService.addBrand(brand);
		return "redirect:/brand/list.do";
	}
	
	//删除一个品牌
	@RequestMapping(value = "/brand/delete.do")
	public String delete(Integer id,String name,Integer isDisplay,ModelMap model){
		//删除
		 
		//判断名字是否为空
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		if(null!=isDisplay){
			model.addAttribute("isDisplay", isDisplay);
		}
		
		//跳转到列表界面
		return "redirect:/brand/list.do";
	}
}
