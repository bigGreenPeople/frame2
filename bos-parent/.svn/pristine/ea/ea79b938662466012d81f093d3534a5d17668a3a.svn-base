package com.fj.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fj.bos.domain.Region;
import com.fj.bos.service.IRegionService;
import com.fj.bos.utils.PinYin4jUtils;
import com.fj.bos.web.action.Base.BaseAction;
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region>{
	//使用属性驱动(这里的上传只要获得流就可以了)
	private File regionFile;
	@Autowired
	private IRegionService regionService;
	
	//区域导入(这里要使用到poi技术)
	public String importXls() throws Exception{
		//定义我们的list 用来装所有的region
		List<Region> regionList = new ArrayList<Region>();
		
		//使用poi关联到上传的文件
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(regionFile));
		//获取文件的sheet
		HSSFSheet sheet = hssfWorkbook.getSheet("Sheet1");
		//得到每一行
		for (Row row : sheet) {
			//判断是否是第一行(是第一行的话就跳过)
			int rowNum = row.getRowNum();
			if(rowNum == 0){
				continue;
			}
			
			//得到没一行的数据并且封装到Region对象中
			//得到单元格
			String id = row.getCell(0).getStringCellValue();	
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			Region region = new Region(id, province, city, district, postcode, null, null, null);
			
			//得到去除省区的全称(如:江西井冈山龙市)
			province = province.substring(0, province.length() - 1);
			city = city.substring(0, city.length() - 1);
			district = district.substring(0, district.length() - 1);
			String info = province + city + district;
			//把info使用pinyin4j转换
			String[] headByString = PinYin4jUtils.getHeadByString(info);//(JXJGSLS)
			String shortcode = StringUtils.join(headByString);
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");//(jingganshan)
			
			region.setShortcode(shortcode);
			region.setCitycode(citycode);
//			存放到list
			regionList.add(region);
		}
		
		//批量保存
		regionService.saveBatch(regionList);
		
		return NONE;
	}
	
	//分页
	//分页查询
	public String pageQuery() throws IOException{
		regionService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
		return NONE;
	}
	
	//ajax请求来查询所有数据
	private String q;
	public String listajax(){
		List<Region> list = null;
		if(StringUtils.isNotBlank(q)){
			list = regionService.findListByQ(q);
		}else{
			list = regionService.findAll();
		}
		//这里要排除subareas
		this.java2Json(list, new String[]{"subareas"});
		return NONE;
	}

	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}

	public void setQ(String q) {
		this.q = q;
	}
	
	
}
