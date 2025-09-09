package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.IEmployeeDAO;

public class EmployeeRegisterService {
	
	public void insert(String emp_name, String Seibetsu, String birthday, String busyoId2) {
		IEmployeeDAO employeeDAO = new IEmployeeDAO();
		try {
			employeeDAO.insert(emp_name, Seibetsu, birthday, busyoId2);
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

	
	
	
}
