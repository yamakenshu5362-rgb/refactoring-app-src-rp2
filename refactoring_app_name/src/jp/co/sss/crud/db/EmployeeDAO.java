package jp.co.sss.crud.db;

public interface EmployeeDAO {
	void allSearch();
	void syainSearch();
	void busyoSearch(String syainId);
	void insert(String empName, String gender, String birthday, String syainId);
	void update(String empId);
	void delete();
}
