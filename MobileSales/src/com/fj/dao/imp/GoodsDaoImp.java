package com.fj.dao.imp;

import java.util.ArrayList;
import java.util.List;














import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.fj.dao.GoodsDao;
import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.PageBean;

public class GoodsDaoImp extends BaseDaoImp<Goods> implements GoodsDao {
	@Override
	public PageBean<Goods> findGoodsByCondition(int currentPage,
			GoodsCondition goodsCondition,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Goods where 1=1";
		
		//p���������������ļ���
		List<String> p = new ArrayList<String>();
		//p�����Ǵ�����ǵĲ�����Ҳ����˵customer������ֵ�ͷ����ȥ��
		if(goodsCondition.getGoodsName()!=null && !"".equals(goodsCondition.getGoodsName())){
			//����hql���
			hql+=" and goodsName like ?";
			p.add("%"+goodsCondition.getGoodsName()+"%");
		}
		if(goodsCondition.getMark()!=null){
			//����hql���
			hql+=" and mark=?";
			p.add(goodsCondition.getMark().toString());
		}
		if(goodsCondition.getBigType_id()!=null){
			//����hql���
			hql+=" and smallType.bigType.id=?";
			p.add(goodsCondition.getBigType_id().toString());
		}
		if(goodsCondition.getSmallType_id()!=null){
			//����hql���
			hql+=" and smallType.id=?";
			p.add(goodsCondition.getSmallType_id().toString());
		}
		/*for (Object object : p) {
			System.out.print(object.toString()+"   ");
		}*/
		//�����pageBean����Ϣ
		//��ѯ�õ��ܼ�¼��
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalCount(this.getCount(goodsCondition));
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
		
		//hql+=" limit "+(pageBean.getBegin()-1)+","+pageBean.getPageSize();
		
		@SuppressWarnings("unchecked")
		//List<Goods> list = (List<Goods>) this.getHibernateTemplate().find(hql, p.toArray());
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql).
		setFirstResult(pageBean.getBegin()-1).setMaxResults(pageBean.getPageSize());
		
		for(int i=0;i<p.size();i++){
			query.setString(i, (String) p.get(i));
		}
		List list = query.list();
		pageBean.setList(list);
		
		return pageBean;
	}
	
	public Integer getCount(GoodsCondition goodsCondition) {
		//���߲�ѯ
		DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class,"g").createAlias("smallType", "s");
		
		//p�����Ǵ�����ǵĲ�����Ҳ����˵customer������ֵ�ͷ����ȥ��
		if(goodsCondition.getGoodsName()!=null && !"".equals(goodsCondition.getGoodsName())){
			//����hql���
			criteria.add(Restrictions.like("g.goodsName","%"+goodsCondition.getGoodsName()+"%"));
		}
		if(goodsCondition.getMark()!=null){
			criteria.add(Restrictions.eq("g.mark", goodsCondition.getMark()));
		}
		if(goodsCondition.getBigType_id()!=null){
			criteria.add(Restrictions.eq("s.bigType.id", goodsCondition.getBigType_id()));
		}
		if(goodsCondition.getSmallType_id()!=null){
			criteria.add(Restrictions.eq("s.id", goodsCondition.getSmallType_id()));
		}
		criteria.setProjection(Projections.count("id"));
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
		//�����Ϊ��
		if(list.size()!=0 && list!=null){
			//�������ǵļ�¼��
			return list.get(0).intValue();
		}
		return 0;		
	}
	
	@Override
	public PageBean<Goods> findGoodsTheFirst(PageBean<Goods> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		//ʹ��hql
		Query query = this.getSessionFactory().getCurrentSession().createQuery("from Goods g order by g.number desc");
		
		//��ѯ�õ��ܼ�¼��
		pageBean.setTotalCount(10);
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
		List<Goods> list = query.setFirstResult(pageBean.getBegin()-1).setMaxResults(pageBean.getPageSize()).list();
		pageBean.setList(list);
		//�������
		return pageBean;
	}
	
	@Override
	public PageBean<Goods> findGoodsByCreaTime(int day, PageBean<Goods> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		List<Long> listCount = (List<Long>) this.getSessionFactory().getCurrentSession().createSQLQuery("SELECT count(*) FROM tb_goods WHERE DATE_SUB(CURDATE(), INTERVAL "+day+" DAY) <= DATE(creaTime)").list();
		//�����Ϊ��
		if(listCount.size()!=0 && listCount!=null){
			//�������ǵļ�¼��
			pageBean.setTotalCount(Integer.parseInt(listCount.get(0)+""));
		}else{
			pageBean.setTotalCount(0);
		}
		//��ѯ�õ��ܼ�¼��
		//count.intValue());
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
		String sql = "SELECT * FROM tb_goods WHERE DATE_SUB(CURDATE(), INTERVAL "+day+" DAY) <= DATE(creaTime) LIMIT "+(pageBean.getBegin()-1)+","+pageBean.getPageSize();
		SQLQuery sQLQuery = this.getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(Goods.class);
		@SuppressWarnings("unchecked")
		List<Goods> list = (List<Goods>) sQLQuery.list();
		pageBean.setList(list);
		
		return pageBean;
	}
}
