package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService {

	public void syainSearch() {
		
		ConstantMsg c = new ConstantMsg();
		IEmployeeDAO employeeDAO = new IEmployeeDAO();

		try {
			
			List<Employee> syainSearchAns = employeeDAO.syainSearch();
			for(Employee e:syainSearchAns) {
				System.out.print(e.getEmpId() + c.tab);
				System.out.print(e.getEmpName() + c.tab);
				System.out.print(e.getGender() + c.tab);
				System.out.print(e.getBirthday() + c.tab);
				System.out.println(e.getDeptName());
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
