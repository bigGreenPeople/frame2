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
	//ʹ����������(������ϴ�ֻҪ������Ϳ�����)
	private File regionFile;
	@Autowired
	private IRegionService regionService;
	
	//������(����Ҫʹ�õ�poi����)
	public String importXls() throws Exception{
		//�������ǵ�list ����װ���е�region
		List<Region> regionList = new ArrayList<Region>();
		
		//ʹ��poi�������ϴ����ļ�
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(regionFile));
		//��ȡ�ļ���sheet
		HSSFSheet sheet = hssfWorkbook.getSheet("Sheet1");
		//�õ�ÿһ��
		for (Row row : sheet) {
			//�ж��Ƿ��ǵ�һ��(�ǵ�һ�еĻ�������)
			int rowNum = row.getRowNum();
			if(rowNum == 0){
				continue;
			}
			
			//�õ�ûһ�е����ݲ��ҷ�װ��Region������
			//�õ���Ԫ��
			String id = row.getCell(0).getStringCellValue();	
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			Region region = new Region(id, province, city, district, postcode, null, null, null);
			
			//�õ�ȥ��ʡ����ȫ��(��:��������ɽ����)
			province = province.substring(0, province.length() - 1);
			city = city.substring(0, city.length() - 1);
			district = district.substring(0, district.length() - 1);
			String info = province + city + district;
			//��infoʹ��pinyin4jת��
			String[] headByString = PinYin4jUtils.getHeadByString(info);//(JXJGSLS)
			String shortcode = StringUtils.join(headByString);
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");//(jingganshan)
			
			region.setShortcode(shortcode);
			region.setCitycode(citycode);
//			��ŵ�list
			regionList.add(region);
		}
		
		//��������
		regionService.saveBatch(regionList);
		
		return NONE;
	}
	
	//��ҳ
	//��ҳ��ѯ
	public String pageQuery() throws IOException{
		regionService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
		return NONE;
	}
	
	//ajax��������ѯ��������
	private String q;
	public String listajax(){
		List<Region> list = null;
		if(StringUtils.isNotBlank(q)){
			list = regionService.findListByQ(q);
		}else{
			list = regionService.findAll();
		}
		//����Ҫ�ų�subareas
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
