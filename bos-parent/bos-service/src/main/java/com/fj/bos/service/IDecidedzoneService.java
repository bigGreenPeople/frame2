package com.fj.bos.service;

import com.fj.bos.domain.Decidedzone;
import com.fj.bos.utils.PageBean;

public interface IDecidedzoneService {
	//保存定区方法
	/**
	 * @param decidedzone 要更新的定区信息
	 * @param subareaid		所关联的分区集合
	 */
	public void save(Decidedzone decidedzone,String[] subareaid);
	//分页
	public void pageQuery(PageBean pageBean);
}
