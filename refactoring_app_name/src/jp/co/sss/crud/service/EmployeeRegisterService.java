package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeRegisterService {
	
	public void insert(String emp_name, String Seibetsu, String birthday, String busyoId2) throws SystemErrorException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			employeeDAO.insert(emp_name, Seibetsu, birthday, busyoId2);
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e1) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR);
		}
		
	}

	
	
	
}
