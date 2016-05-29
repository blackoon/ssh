package com.bluedot.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bluedot.dao.IBaseDao;
import com.bluedot.util.PageBean;
import com.bluedot.vo.Employee;
//IBaseDao告诉你做什么
//HibernateDaoSupport告诉你怎么做
public class GenericDao<T, ID extends Serializable> extends HibernateDaoSupport implements IBaseDao<T, ID> {
	public void insert(T obj) {
		this.getHibernateTemplate().save(obj);
	}
	
	public void delete(Class<T> c, ID id) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(c, id));
	}
	
	public void update(T obj) {
		this.getHibernateTemplate().update(obj);
	}
	
	public T queryById(Class<T> c, ID id) {
		return (T)this.getHibernateTemplate().get(c, id);
	}
	
	public List<T> queryAll(Class<T> c) {
		return this.getHibernateTemplate().loadAll(c);
	}
	
	public List queryByHql(String hql, Object[] param) {
		return this.getHibernateTemplate().find(hql, param);
	}
	
	public PageBean<T> pageQuery(int pagesize, int pagenum, String qhql, String chql, List<Object> param) {
		Session session = this.getSession();
		PageBean<T> page = new PageBean<T>();
		Query query = session.createQuery(qhql);
		for(int i=0;i<param.size();i++) {
			query.setParameter(i, param.get(i));
		}
		query.setFirstResult((pagenum-1)*pagesize);
		query.setMaxResults(pagesize);
		List<T> data = query.list();
		
		query = session.createQuery(chql);
		for(int i=0;i<param.size();i++) {
			query.setParameter(i, param.get(i));
		}
		int recordcount = Integer.parseInt(query.uniqueResult().toString());
		
		int pagecount = 0;
		pagecount = recordcount / pagesize;
		if(recordcount%pagesize!=0) {
			pagecount++;
		}
		
		page.setPagesize(pagesize);
		page.setPagenum(pagenum);
		page.setPagecount(pagecount);
		page.setRecordcount(recordcount);
		page.setData(data);
		return page;
	}
	
}
