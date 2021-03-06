package com.fj.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fj.exception.CustomException;
import com.fj.po.Items;
import com.fj.po.ItemsCustom;
import com.fj.po.ItemsQueryVo;
import com.fj.service.ItemsService;
import com.fj.service.imp.ItemsServiceImp;
import com.fj.valid.ValidGroup1;

@Controller
//窄化请求映射
@RequestMapping("/item")
public class ItemsController {
	//注解注入
	@Autowired
	private ItemsService iItemsService;
	
	//根据条件进行查询   如果查询为空默认查询所有商品
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
		
		//异常测试
//		if(true){
//			throw new CustomException("异常测试");
//		}
		
		
		List<ItemsCustom> list = iItemsService.findItemsList(itemsQueryVo);
		
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
	 * @Validated和BindingResult必须是成对出现(一前一后)
	 * BindingResult是校检错误信息
	 * 数据回显：
	 * springmvc自动将形参中的pojo重新放回request域中
	 * 如果key不是pojo的类名(首字母小写)，可以使用@ModelAttribute完成数据回显。
	 * */
	//@Validated(value={ValidGroup1.class})配置分组校验
	@RequestMapping(value="/editItemSubmit.action",method={RequestMethod.GET,RequestMethod.POST})
	public String editItemSubmit(Model model,Integer id,@ModelAttribute("itemsCustom") @Validated(value={ValidGroup1.class}) ItemsCustom itemsCustom,BindingResult bindingResult,MultipartFile pictureFile) throws Exception{
		//文件上传的代码
		//源文件的名称
		String pictureFile_name = pictureFile.getOriginalFilename();
		//新文件的名称
		String newFileName = UUID.randomUUID().toString()+pictureFile_name.substring(pictureFile_name.lastIndexOf("."));
		//上传图片
		File uploadPic = new File("D:/images/"+newFileName);
		//向磁盘写文件
		pictureFile.transferTo(uploadPic);
		//如果校检有错误
		if(bindingResult.hasErrors()){
			//数据回显
			model.addAttribute("id", id);
			model.addAttribute("errors",bindingResult);
			//跳转回我们的界面
			return "forward:editItem.action";
		}
		
		itemsCustom.setPic(newFileName);
		iItemsService.saveItem(id, itemsCustom);
		//跳转到成功界面
		return "success";
	}
	
	//批量删除 
	//Integer[] item_id 接受到form表单的item_id
	@RequestMapping("/deleteitem.action")
	public String deleteitem(Integer[] item_id) throws Exception{
		//这里做批量删除的业务逻辑
		iItemsService.deleteAllItems(item_id);
		//请求转发到查询所有的商品
		return "redirect:/item/queryItems.action";
	}
	
	//到批量修改界面
	@RequestMapping("/editItemsQuery.action")
	public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
		List<ItemsCustom> list = iItemsService.findItemsList(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", list);
		modelAndView.setViewName("editItemsQuery");
		return modelAndView;
	}
	
	//提交批量修改
	@RequestMapping("/editItemsAllSubmit.action")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo)throws Exception{
		//修改的业务逻辑
		iItemsService.saveAllItems(itemsQueryVo);
		return "success";
	}
	
	
}
