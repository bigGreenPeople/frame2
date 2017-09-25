package com.fj.action;

import java.io.File;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fj.domain.Affiche;
import com.fj.domain.BigType;
import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.Link;
import com.fj.domain.PageBean;
import com.fj.domain.SmallType;
import com.fj.service.BigTypeService;
import com.fj.service.GoodsService;
import com.fj.utils.UniName;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GoodsAction extends ActionSupport{
	//�ϴ����ļ���
	private File fieldName;
	//�ϴ��ļ�������
	private String fieldNameContentType;
	//�ϴ��ļ����ļ��� 	fieldName+FileName(�̶�)
	private String fieldNameFileName;
	//��������ǵķ�����
	private GoodsService goodsService;
	private BigTypeService bigTypeService;
	//Ĭ�ϵ�ǰҳ�ǵ�һҳ
	private Integer currentPage=1;
	//����������
	private GoodsCondition goodsCondition;
	//��Ʒ
	private Goods goods;
	//������id
	private Integer bigTypeId;
	private Set<SmallType> smallTypes;
	
	//��ѯ���е���Ʒ		��ҳ��ʾ��ҳ��
	public String findAllGoods() throws Exception{
		//�������ǵĲ�ѯ����
		PageBean<Goods> pageBean = new PageBean<Goods>();
		//���õ�ǰҳ��ÿҳ������
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<Goods> goodss = goodsService.findAllGoods(pageBean);
		
		//���뵽�������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("goodss", goodss);
		
		return "findAllGoods";
	}
	
	//����Ʒ��ϸ����
	public String showGoods() throws Exception{
		Goods findGoodsById = goodsService.findGoodsById(goods.getId());
		ServletActionContext.getRequest().setAttribute("goods", findGoodsById);
		return "showGoods";
	}
	
	//ɾ����Ʒ�ؼ�
	public String delGoodsFire() throws Exception{
		String result="ɾ����Ʒ�ؼ۳ɹ�";
		//�ı�
		try {
			goodsService.deleteFreePrice(goods);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="ɾ����Ʒ�ؼ�ʧ��!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		return "toGoodsResult";
	}
	
	//ɾ����Ʒ
	public String deleteGoods() throws Exception{
		String result="ɾ����Ʒ�ɹ�";
		//�ı�
		try {
			goodsService.deleteGoods(goods);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="ɾ����Ʒʧ��!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		return "toGoodsResult";
	}
	
	//������Ʒ���ؼ�
	public String setingGoods() throws Exception{
		String result="������Ʒ�ؼ۳ɹ�";
		//�ı�
		try {
			goodsService.updateFreePrice(goods);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="������Ʒ�ؼ�ʧ��!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		return "toGoodsResult";
	}
	
//	��������Ʒ����
	public String toSetGoods() throws Exception{
		Goods findGoodsById = goodsService.findGoodsById(goods.getId());
		ServletActionContext.getRequest().setAttribute("goods", findGoodsById);
		return "tosetGoods";
	}
	
	//����ѯ��Ʒ����
	public String toFindGoods() throws Exception{
		
		//�õ����еĴ����
		List<BigType> list = bigTypeService.findAllBigType();
		//����request
		if(list!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("list", list);
		}
		return "toFindGoods";
	}
	
	//��ѯ��Ʒ
	public String findGoods() throws Exception{
		
		PageBean<Goods> findAllGoods = goodsService.findAllGoods(currentPage, goodsCondition);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("goodss", findAllGoods);
		request.setAttribute("goodsCondition", goodsCondition);
		return "findGoods";
	}
	
	//�������Ʒҳ��
	public String toAddGoods() throws Exception{
		//ȡ�����ô����
		List<BigType> list = bigTypeService.findAllBigType();
		//����request
		if(list!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("list", list);
		}
		return "toAddGoods";
	}
	
	//�����Ʒ
	public String addGoods() throws Exception{
		String result="�����Ʒ�ɹ�";
		//���
		try {
			//�����ļ������·��
			String path = "/file";
			//�õ�����·��
			String repath = ServletActionContext.getServletContext().getRealPath(path);
			//System.out.println(repath);
			//file���ļ���ȫ·��
			String fname = UniName.getFname(fieldNameFileName);
			File file = new File(repath,UniName.getFname(fname));
			//ʹ�����������ļ���д��
			FileUtils.copyFile(fieldName, file);
			goods.setPirture(fname);
			goodsService.addGoods(goods);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="�����Ʒʧ��!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		return "toGoodsResult";
	} 
	
	//���Ķ�������
	public String findSmallTypeByBigTypeAjax() throws Exception{
		//String parameter = ServletActionContext.getRequest().getParameter("bigTypeId");
		//System.out.println(bigTypeId);
		smallTypes = bigTypeService.findBigTypeById(bigTypeId).getSmallTypesSet();
		
		return "bigTypeAjax";
	}
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setBigTypeService(BigTypeService bigTypeService) {
		this.bigTypeService = bigTypeService;
	}

	public Integer getBigTypeId() {
		return bigTypeId;
	}

	public void setBigTypeId(Integer bigTypeId) {
		this.bigTypeId = bigTypeId;
	}


	public Set<SmallType> getSmallTypes() {
		return smallTypes;
	}

	public void setSmallTypes(Set<SmallType> smallTypes) {
		this.smallTypes = smallTypes;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public File getFieldName() {
		return fieldName;
	}

	public void setFieldName(File fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldNameContentType() {
		return fieldNameContentType;
	}

	public void setFieldNameContentType(String fieldNameContentType) {
		this.fieldNameContentType = fieldNameContentType;
	}

	public String getFieldNameFileName() {
		return fieldNameFileName;
	}

	public void setFieldNameFileName(String fieldNameFileName) {
		this.fieldNameFileName = fieldNameFileName;
	}

	public GoodsCondition getGoodsCondition() {
		return goodsCondition;
	}

	public void setGoodsCondition(GoodsCondition goodsCondition) {
		this.goodsCondition = goodsCondition;
	}

	
}
