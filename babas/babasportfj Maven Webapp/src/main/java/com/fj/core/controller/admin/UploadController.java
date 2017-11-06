package com.fj.core.controller.admin;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fj.common.web.ResponseUtils;
import com.fj.common.web.springmvc.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
/**
 * 上传图片
 * 商品
 * 品牌
 * 商品介绍Fck
 * @author bigRedPeople
 *
 */
@Controller
public class UploadController {
	//上传图片
	@RequestMapping("/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic,HttpServletResponse response){
		//得到文件扩展名称
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		
		//图片的生成策略
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//得到图片名称的一部分
		String format = dateFormat.format(new Date());
		//随机生成3位数
		Random r = new Random();
		for(int i=0;i<3;i++){
			format += r.nextInt(10);
		}
		
		//异步提交图片
		//实例化一个jersey
		Client client = new Client();
		//保存数据库
		String path = "upload/" + format + "." + ext;
		//另一台服务器的请求路径
		String url = Constants.IMAGE_URL+path;
		
		//设置请求路径
		WebResource resource = client.resource(url);
		//发送
		try {
			resource.put(String.class, pic.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//返回两个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);
		//数据回显
		ResponseUtils.renderJson(response, jo.toString());
	}
}
