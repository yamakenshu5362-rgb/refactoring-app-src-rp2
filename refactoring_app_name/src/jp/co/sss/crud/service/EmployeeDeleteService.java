package jp.co.sss.crud.service;

import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService {

	public void delete() throws SystemErrorException{
		try {
			ConstantMsg c = new ConstantMsg();
			IEmployeeDAO employeeDAO = new IEmployeeDAO();
	
			employeeDAO.delete();
		} catch (Exception e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR);
		}
	}
}
