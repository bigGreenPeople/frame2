package com.fj.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class Activiti01 {
	//调用ProcessEngine的静态方法得到ProcessEngine
	ProcessEngines.getDefaultProceeEngine();
	//创建流程引擎对象
	@Test
	public void testDBByPro() throws Exception{
//		//加载配置文件(得到流程引擎	 创建表)
//		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
//				.buildProcessEngine();
		System.out.println(processEngine);
	}
	
	
}
