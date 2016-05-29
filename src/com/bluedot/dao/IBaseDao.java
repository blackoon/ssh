package com.bluedot.dao;

import java.io.Serializable;
import java.util.List;

import com.bluedot.util.PageBean;

public interface IBaseDao<T, ID extends Serializable> {
	
	public void insert(T obj);
	public void delete(Class<T> c, ID id);
	public void update(T obj);
	public T queryById(Class<T> c, ID id);
	public List<T> queryAll(Class<T> c);
	public List queryByHql(String hql, Object[] param);
	public PageBean<T> pageQuery(int pagesize, int pagenum, String qhql, String chql, List<Object> param);
}
