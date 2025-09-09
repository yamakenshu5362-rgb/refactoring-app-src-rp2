package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.IEmployeeDAO;

public class EmployeeUpdateService {
	
	public void update(String emp_id) {
		IEmployeeDAO employeeDAO = new IEmployeeDAO();
		try {
			employeeDAO.update(emp_id);
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}

}
