package com.fj.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class Activiti01 {
	//����ProcessEngine�ľ�̬�����õ�ProcessEngine
	ProcessEngines.getDefaultProceeEngine();
	//���������������
	@Test
	public void testDBByPro() throws Exception{
//		//���������ļ�(�õ���������	 ������)
//		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
//				.buildProcessEngine();
		System.out.println(processEngine);
	}
	
	
}
