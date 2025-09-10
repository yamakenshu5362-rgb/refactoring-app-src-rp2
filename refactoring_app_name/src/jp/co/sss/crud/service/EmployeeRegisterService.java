package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeRegisterService {
	
	public void insert(String emp_name, String Seibetsu, String birthday, String busyoId2) throws SystemErrorException {
		IEmployeeDAO employeeDAO = new IEmployeeDAO();
		try {
			employeeDAO.insert(emp_name, Seibetsu, birthday, busyoId2);
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e1) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR);
		}
		
	}

	
	
	
}
