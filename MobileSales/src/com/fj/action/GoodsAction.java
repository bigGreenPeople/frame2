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
	//上传的文件流
	private File fieldName;
	//上传文件的类型
	private String fieldNameContentType;
	//上传文件的文件名 	fieldName+FileName(固定)
	private String fieldNameFileName;
	//定义好我们的服务类
	private GoodsService goodsService;
	private BigTypeService bigTypeService;
	//默认当前页是第一页
	private Integer currentPage=1;
	//定义条件类
	private GoodsCondition goodsCondition;
	//商品
	private Goods goods;
	//大类别的id
	private Integer bigTypeId;
	private Set<SmallType> smallTypes;
	
	//查询所有的商品		分页显示到页面
	public String findAllGoods() throws Exception{
		//创建我们的查询条件
		PageBean<Goods> pageBean = new PageBean<Goods>();
		//设置当前页和每页的数量
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<Goods> goodss = goodsService.findAllGoods(pageBean);
		
		//放入到域对象里
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("goodss", goodss);
		
		return "findAllGoods";
	}
	
	//到商品详细界面
	public String showGoods() throws Exception{
		Goods findGoodsById = goodsService.findGoodsById(goods.getId());
		ServletActionContext.getRequest().setAttribute("goods", findGoodsById);
		return "showGoods";
	}
	
	//删除商品特价
	public String delGoodsFire() throws Exception{
		String result="删除商品特价成功";
		//改变
		try {
			goodsService.deleteFreePrice(goods);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="删除商品特价失败!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		return "toGoodsResult";
	}
	
	//删除商品
	public String deleteGoods() throws Exception{
		String result="删除商品成功";
		//改变
		try {
			goodsService.deleteGoods(goods);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="删除商品失败!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		return "toGoodsResult";
	}
	
	//设置商品的特价
	public String setingGoods() throws Exception{
		String result="设置商品特价成功";
		//改变
		try {
			goodsService.updateFreePrice(goods);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="设置商品特价失败!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		return "toGoodsResult";
	}
	
//	到设置商品界面
	public String toSetGoods() throws Exception{
		Goods findGoodsById = goodsService.findGoodsById(goods.getId());
		ServletActionContext.getRequest().setAttribute("goods", findGoodsById);
		return "tosetGoods";
	}
	
	//到查询商品界面
	public String toFindGoods() throws Exception{
		
		//得到所有的大类别
		List<BigType> list = bigTypeService.findAllBigType();
		//放入request
		if(list!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("list", list);
		}
		return "toFindGoods";
	}
	
	//查询商品
	public String findGoods() throws Exception{
		
		PageBean<Goods> findAllGoods = goodsService.findAllGoods(currentPage, goodsCondition);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("goodss", findAllGoods);
		request.setAttribute("goodsCondition", goodsCondition);
		return "findGoods";
	}
	
	//到添加商品页面
	public String toAddGoods() throws Exception{
		//取得所得大类别
		List<BigType> list = bigTypeService.findAllBigType();
		//放入request
		if(list!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("list", list);
		}
		return "toAddGoods";
	}
	
	//添加商品
	public String addGoods() throws Exception{
		String result="添加商品成功";
		//添加
		try {
			//设置文件保存的路径
			String path = "/file";
			//得到绝对路径
			String repath = ServletActionContext.getServletContext().getRealPath(path);
			//System.out.println(repath);
			//file是文件的全路径
			String fname = UniName.getFname(fieldNameFileName);
			File file = new File(repath,UniName.getFname(fname));
			//使用组件包完成文件的写入
			FileUtils.copyFile(fieldName, file);
			goods.setPirture(fname);
			goodsService.addGoods(goods);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="添加商品失败!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		return "toGoodsResult";
	} 
	
	//类别的二级联动
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
