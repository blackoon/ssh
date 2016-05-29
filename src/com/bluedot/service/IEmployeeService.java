package com.bluedot.service;

import com.bluedot.util.PageBean;
import com.bluedot.vo.Employee;

public interface IEmployeeService {
	public PageBean<Employee> pageQuery(int pagesize, int pagenum, Employee employee);
	public Employee queryEmpByid(String empid);
	public void insertEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void delEmp(String empid);
}
