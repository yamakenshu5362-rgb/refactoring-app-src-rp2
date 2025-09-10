package jp.co.sss.crud.db;

import java.util.List;

import jp.co.sss.crud.dto.Employee;

public interface IEmployeeDAO {
	List<Employee> allSearch();
	List<Employee> syainSearch();
	List<Employee> busyoSearch(String syainId);
	void insert(String empName, String gender, String birthday, String syainId);
	void update(String empId);
	void delete();
}
