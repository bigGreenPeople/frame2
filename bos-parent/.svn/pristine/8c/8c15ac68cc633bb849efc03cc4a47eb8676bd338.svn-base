package com.fj.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.fj.bos.domain.Region;
import com.fj.bos.domain.Subarea;
import com.fj.bos.service.ISubareaService;
import com.fj.bos.utils.FileUtils;
import com.fj.bos.web.action.Base.BaseAction;

@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Autowired
	private ISubareaService subareaService;
	
	//保存的方法
	public String add(){
		subareaService.save(model);
		return LIST;
	}
	
	//分页查询
	public String pageQuery() throws IOException{
		//得到离线查询对象
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		//得到关键字
		String addresskey = model.getAddresskey();
		//判断关键字是否为空
		if(StringUtils.isNotBlank(addresskey)){
			//添加条件
			dc.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
		}
		
		//得到其他条件
		Region region = model.getRegion();
		
		if(region!=null){
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			
			//给region表取一个别名方便下次的内连接(region是类的属性)
			dc.createAlias("region", "r");
			
			//一一添加条件
			if(StringUtils.isNotBlank(province)){
				//添加条件
				dc.add(Restrictions.like("r.province", "%"+province+"%"));
			}
			if(StringUtils.isNotBlank(city)){
				//添加条件
				dc.add(Restrictions.like("r.city", "%"+city+"%"));
			}
			if(StringUtils.isNotBlank(district)){
				//添加条件
				dc.add(Restrictions.like("r.district", "%"+district+"%"));
			}
			
		}
		
		subareaService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decidedzone","subareas"});
		return NONE;
	}
	
	//查询所有未关联的分区
	public String listajax(){
		List<Subarea> list = subareaService.findListNotAssociation();
		//转换并响应
		java2Json(list, new String[]{"decidedzone","region"});
		return NONE;
	}
	
	//导出分区数据
	public String exportXls() throws IOException{
		
		//1:查询所有的数据
		List<Subarea> list = subareaService.findAll();
		//2:使用POI将LIST写入到excel
		//创建一个文件
		HSSFWorkbook  workbook = new HSSFWorkbook();
		//创建一个sheet
		HSSFSheet sheet = workbook.createSheet("分区数据");
		//先创建第一行的标题行
		HSSFRow row = sheet.createRow(0);
		//创建单元格(并设置里面的内容)
		row.createCell(0).setCellValue("分区编号");
		row.createCell(1).setCellValue("开始编号");
		row.createCell(2).setCellValue("结束编号");
		row.createCell(3).setCellValue("位置信息");
		row.createCell(4).setCellValue("省市区");

		for (Subarea subarea : list) {
			//创建出最后一行
			HSSFRow dataRow  = sheet.createRow(sheet.getLastRowNum()+1);
			//设置里面的数据
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getStartnum());
			dataRow.createCell(2).setCellValue(subarea.getEndnum());
			dataRow.createCell(3).setCellValue(subarea.getPosition());
			dataRow.createCell(4).setCellValue(subarea.getRegion().getName());
			
		}
		//3:(文件已经创建完成)使用文件流进行下载(一个流两个头)
		//设置文件的名称
		String fileName = "分区数据.xls";
		//从Tomcat的web.xml文件中获得文件的类型
		String mimeType = ServletActionContext.getServletContext().getMimeType(fileName);
		
		//得到文件的输出流
		ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
		//设置文件的类型
		ServletActionContext.getResponse().setContentType(mimeType);
		
		//根据客户端的类型对文件名进行编码(得到编码后的文件名)
		//获取类型
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		fileName = FileUtils.encodeDownloadFilename(fileName, agent);
		
		//告诉浏览器我的是下载文件
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename="+fileName);
		//进行响应回写
		workbook.write(outputStream);
		
		return NONE;
	}
}
