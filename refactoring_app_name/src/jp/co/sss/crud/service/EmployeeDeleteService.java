package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService {

	public void delete() throws SystemErrorException{
		try {
			ConstantMsg c = new ConstantMsg();
			EmployeeDAO employeeDAO = new EmployeeDAO();
	
			employeeDAO.delete();
		} catch (Exception e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR);
		}
	}
}
