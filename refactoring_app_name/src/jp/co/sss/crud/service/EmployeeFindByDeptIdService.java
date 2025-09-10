package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByDeptIdService {
	
	public void busyoSearch(String empId) throws SystemErrorException {
		
		ConstantMsg c = new ConstantMsg();
		EmployeeDAO employeeDAO = new EmployeeDAO();

		try {
			
			List<Employee> busyoSearchAns = employeeDAO.busyoSearch(empId);
			if(!(busyoSearchAns == null || busyoSearchAns.size() == 0)) {
				for(Employee e:busyoSearchAns) {
					System.out.print(e.getEmpId() + c.tab);
					System.out.print(e.getEmpName() + c.tab);
					System.out.print(e.getGender() + c.tab);
					System.out.print(e.getBirthday() + c.tab);
					System.out.println(e.getDeptName());
				}
			}
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR);
		}
		
		
	}

}
