package com.bluedot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bluedot.dao.IBaseDao;
import com.bluedot.service.IEmployeeService;
import com.bluedot.util.PageBean;
import com.bluedot.vo.Employee;

public class EmployeeService implements IEmployeeService {

	private IBaseDao<Employee, String> empDao;
	
	public void delEmp(String empid) {
		empDao.delete(Employee.class, empid);
	}

	public void insertEmp(Employee employee) {
		empDao.insert(employee);
	}

	public PageBean pageQuery(int pagesize, int pagenum, Employee employee) {
		PageBean page = new PageBean();
		String qhql = "from Employee as e where 1=1 ";
		String chql = "select count(e.empid) from Employee as e where 1=1";
		List<Object> param = new ArrayList<Object>();
		
		if(employee!=null) {
			if(employee.getEmpname()!=null && !"".equals(employee.getEmpname())) {
				qhql = qhql + " and e.empname like ?";
				chql = chql + " and e.empname like ?";
				param.add("%" + employee.getEmpname() + "%");
			}
			
			if(employee.getDept()!=null) {
				qhql = qhql + " and e.dept.deptname like ?";
				chql = chql + " and e.dept.deptname like ?";
				param.add("%" + employee.getDept().getDeptname() + "%");
			}
		}
		page = empDao.pageQuery(pagesize, pagenum, qhql, chql, param);
		return page;
	}

	public Employee queryEmpByid(String empid) {
		return empDao.queryById(Employee.class, empid);
	}
	
	public void updateEmp(Employee employee) {
		empDao.update(employee);
	}

	public IBaseDao<Employee, String> getEmpDao() {
		return empDao;
	}

	public void setEmpDao(IBaseDao<Employee, String> empDao) {
		this.empDao = empDao;
	}
	
	
}
