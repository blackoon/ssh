package com.bluedot.action;


import com.bluedot.service.IEmployeeService;
import com.bluedot.util.PageBean;
import com.bluedot.vo.Employee;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	
	private IEmployeeService empService;
	private PageBean<Employee> page;
	private Employee employee;
	
	public String pageQuery() throws Exception {
		if(page==null) {
			page = new PageBean<Employee>();
			page.setPagesize(5);
			page.setPagenum(1);
		}
		page = empService.pageQuery(page.getPagesize(), page.getPagenum(), employee);
		return "pageQuery";
		
	}
	
	public String inserOrUpdate() throws Exception {
		if(employee.getEmpid()==null || "".equals(employee.getEmpid())) {
			empService.insertEmp(employee);
		} else {
			empService.updateEmp(employee);
		}
		employee = null;
		return pageQuery();
	}
	
	public String delete() throws Exception {
		empService.delEmp(employee.getEmpid());
		return pageQuery();
	}
	
	public String view() throws Exception {
		employee = empService.queryEmpByid(employee.getEmpid());
		return "view";
	}
	
	public String preUpdate() throws Exception {
		employee = empService.queryEmpByid(employee.getEmpid());
		return "update";
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PageBean<Employee> getPage() {
		return page;
	}

	public void setPage(PageBean<Employee> page) {
		this.page = page;
	}

	public IEmployeeService getEmpService() {
		return empService;
	}

	public void setEmpService(IEmployeeService empService) {
		this.empService = empService;
	}
	
	
}
