package com.fj.dao.imp;

import java.util.ArrayList;
import java.util.List;







import org.hibernate.Query;
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
			GoodsCondition goodsCondition) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Goods where 1=1";
		
		//p是我们所有条件的集合
		List<String> p = new ArrayList<String>();
		//p里面是存放我们的参数（也就是说customer属性有值就放入进去）
		if(goodsCondition.getGoodsName()!=null && !"".equals(goodsCondition.getGoodsName())){
			//连接hql语句
			hql+=" and goodsName like ?";
			p.add("%"+goodsCondition.getGoodsName()+"%");
		}
		if(goodsCondition.getMark()!=null){
			//连接hql语句
			hql+=" and mark=?";
			p.add(goodsCondition.getMark().toString());
		}
		if(goodsCondition.getBigType_id()!=null){
			//连接hql语句
			hql+=" and smallType.bigType.id=?";
			p.add(goodsCondition.getBigType_id().toString());
		}
		if(goodsCondition.getSmallType_id()!=null){
			//连接hql语句
			hql+=" and smallType.id=?";
			p.add(goodsCondition.getSmallType_id().toString());
		}
		/*for (Object object : p) {
			System.out.print(object.toString()+"   ");
		}*/
		//计算出pageBean的信息
		//查询得到总记录数
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalCount(this.getCount(goodsCondition));
		//计算开始位置
		int begin = (pageBean.getCurrentPage()-1)*pageBean.getPageSize()+1;
		pageBean.setBegin(begin);
		//计算出总页数
		int totalPage=pageBean.getTotalCount()%pageBean.getPageSize()==0?
				pageBean.getTotalCount()/pageBean.getPageSize():
					pageBean.getTotalCount()/pageBean.getPageSize()+1;
		pageBean.setTotalPage(totalPage);
		//计算出结束位置
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
		//离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class,"g").createAlias("smallType", "s");
		
		//p里面是存放我们的参数（也就是说customer属性有值就放入进去）
		if(goodsCondition.getGoodsName()!=null && !"".equals(goodsCondition.getGoodsName())){
			//连接hql语句
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
		//如果不为空
		if(list.size()!=0 && list!=null){
			//返回我们的记录数
			return list.get(0).intValue();
		}
		return 0;		
	}
}
