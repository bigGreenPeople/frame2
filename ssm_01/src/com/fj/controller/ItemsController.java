package com.fj.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fj.po.ItemsCustom;
import com.fj.po.ItemsQueryVo;
import com.fj.service.ItemsService;
import com.fj.service.imp.ItemsServiceImp;

@Controller
//խ������ӳ��
@RequestMapping("/item")
public class ItemsController {
	//ע��ע��
	@Autowired
	private ItemsService iItemsService;
	
	//�����������в�ѯ   �����ѯΪ��Ĭ�ϲ�ѯ������Ʒ
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
		
		List<ItemsCustom> list = iItemsService.findItemsList(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", list);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
	/* �����ķ���ֵ:void(ʹ��request��ת) String ModelAndView
	 * Converter������
	 * �������β�HttpServletRequest HttpServletResponse������� 
	 * Ҳ����˵Model��ֵ���뵽Model��
	 * @RequestParam(value="id",required=true)
	 * �����ʾkeyΪid��ֵ����
	 * required��ʾ�˲���һ��Ҫ��
	 * */
	//��ת���޸Ľ���
	@RequestMapping("/editItem.action")
	public String editItem(Model model,@RequestParam(value="id",required=true) Integer id) throws Exception{
		//service���÷����õ���Ʒ����
		ItemsCustom itemsCustom = iItemsService.findItemById(id);
		//��������뵽model��
		model.addAttribute("itemsCustom", itemsCustom);
		//ͨ����ͼ��������תҳ��
		//����ת��
		//return "redirect:editItem"
		//����ת��
		//return "forword:editItem"
		return "editItem";
	}
	
	//�޸���Ʒ��Ϣ
	/*
	 * method:ָ������ֻ�ܱ�get��post����
	 * */
	@RequestMapping(value="/editItemSubmit.action",method={RequestMethod.GET,RequestMethod.POST})
	public String editItemSubmit(Integer id,ItemsCustom itemsCustom) throws Exception{
		iItemsService.saveItem(id, itemsCustom);
		//��ת���ɹ�����
		return "success";
	}
	
	//����ɾ�� 
	//Integer[] item_id ���ܵ�form����item_id
	@RequestMapping("/deleteitem.action")
	public String deleteitem(Integer[] item_id) throws Exception{
		//����������ɾ����ҵ���߼�
		iItemsService.deleteAllItems(item_id);
		//����ת������ѯ���е���Ʒ
		return "redirect:/item/queryItems.action";
	}
	
	//�������޸Ľ���
	@RequestMapping("/editItemsQuery.action")
	public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
		List<ItemsCustom> list = iItemsService.findItemsList(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", list);
		modelAndView.setViewName("editItemsQuery");
		return modelAndView;
	}
	
	//�ύ�����޸�
	@RequestMapping("/editItemsAllSubmit.action")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo)throws Exception{
		//�޸ĵ�ҵ���߼�
		iItemsService.saveAllItems(itemsQueryVo);
		return "success";
	}
	
}
