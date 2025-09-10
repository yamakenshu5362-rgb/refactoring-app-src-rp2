package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService {
	
	public void update(String emp_id) throws SystemErrorException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			employeeDAO.update(emp_id);
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e1) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR);
		}
	}

}
