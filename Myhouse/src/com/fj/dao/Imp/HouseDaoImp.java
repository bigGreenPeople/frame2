package com.fj.dao.Imp;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fj.dao.HouseDao;
import com.fj.domain.House;
import com.fj.domain.PageBean;
import com.fj.utils.TxQueryRunner;

public class HouseDaoImp extends BaseDaoImp<House> implements HouseDao {
	
	@Override
	public PageBean<House> findHouseByCondition(House house,PageBean<House> pageBean) throws Exception {
		// TODO Auto-generated method stub
		//select * from HOUSE where 1=1 and title like '%��%' and price between 50 and 400 and type_id=3
		// and floorage between 40 and 500;
		String intoMessage = "";
		//�ж������Ƿ�Ϊnull
		if(house.getTitle()!=null && !"".equals(house.getTitle())){
			intoMessage+=" and title like '%"+house.getTitle()+"%'";
		}
		// �жϼ۸�
		if(house.getPrice()!=null){
			String priSql = "";
			if(house.getPrice()==100){
				priSql = " and price between 0 and 100";
			}else if(house.getPrice()==200){
				priSql = " and price between 100 and 200";
			}else if(house.getPrice()==1000000){
				priSql = " and price between 200 and 1000000";
			}
			intoMessage+=priSql;
		}
		//�ж������Ƿ�ѡ��
		if(house.getType_id()!=null){
			intoMessage+=" and type_id="+house.getType_id();
		}
		//�ж� �ֵ��Ƿ�ѡ��
		if(house.getStreet_id()!=null){
			intoMessage+=" and street_id="+house.getStreet_id();
		}
		//�ж�floorage�Ƿ�ѡ��
		if(house.getFloorAge()!=null){
			String floorSql = "";
			if(house.getFloorAge()==40){
				floorSql=" and floorage between 0 and "+house.getFloorAge();
			}else if(house.getFloorAge()==500){
				floorSql=" and floorage between 40 and "+house.getFloorAge();
			}else if(house.getFloorAge()==1000000){
				floorSql=" and floorage between 500 and "+house.getFloorAge();
			}
			intoMessage+=floorSql;
		}
		
//		����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//�����page�������Ϣ
		//��ѯ�õ��ܼ�¼��
		pageBean.setTotalCount(this.getCountByCondition(intoMessage));
		//���㿪ʼλ��
		int begin = (pageBean.getCurrentPage()-1)*pageBean.getPageSize()+1;
		pageBean.setBegin(begin);
		//�������ҳ��
		int totalPage=pageBean.getTotalCount()%pageBean.getPageSize()==0?
				pageBean.getTotalCount()/pageBean.getPageSize():
					pageBean.getTotalCount()/pageBean.getPageSize()+1;
		pageBean.setTotalPage(totalPage);
		//���������λ��
		int end = pageBean.getCurrentPage()*pageBean.getPageSize();
		pageBean.setEnd(end);
		//д��sql���
		//String sql = "select * from "+pclazz.getSimpleName();
		String sql = "select t2.* from "
				+ "(select t1.*,rownum rn from (select * from house where 1=1" +intoMessage+")"
						+ " t1 where rownum<="+pageBean.getEnd()+") t2 where rn>="+pageBean.getBegin();
		System.out.println("fjUtils:  "+sql);
		List<House> newlist = qr.query(sql, new BeanListHandler<House>(House.class));
		//����list
		pageBean.setList(newlist);
		return pageBean;
	}
}
