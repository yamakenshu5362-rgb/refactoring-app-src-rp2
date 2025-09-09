package jp.co.sss.crud.db;

import java.util.List;

import jp.co.sss.crud.dto.Employee;

public interface EmployeeDAO {
	List<Employee> allSearch();
	void syainSearch();
	void busyoSearch(String syainId);
	void insert(String empName, String gender, String birthday, String syainId);
	void update(String empId);
	void delete();
}
