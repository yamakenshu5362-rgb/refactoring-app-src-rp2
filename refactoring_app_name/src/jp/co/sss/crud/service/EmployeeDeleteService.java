package jp.co.sss.crud.service;

import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService {

	public void delete(){
		
		ConstantMsg c = new ConstantMsg();
		IEmployeeDAO employeeDAO = new IEmployeeDAO();

		employeeDAO.delete();
		
	}
}
