package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService {

	public void syainSearch() throws SystemErrorException, IllegalInputException{
		
		ConstantMsg c = new ConstantMsg();
		EmployeeDAO employeeDAO = new EmployeeDAO();

		try {
			//社員検索
			List<Employee> syainSearchAns = employeeDAO.syainSearch();
			//該当社員が存在するか確認
			if(!(syainSearchAns == null || syainSearchAns.size() == 0)) {
				//コンソールに該当社員出力
				for(Employee e:syainSearchAns) {
					System.out.print(e.getEmpId() + c.tab);
					System.out.print(e.getEmpName() + c.tab);
					System.out.print(e.getGender() + c.tab);
					System.out.print(e.getBirthday() + c.tab);
					System.out.println(e.getDeptName());
				}
			}
			
		} catch (IllegalInputException e) {
			throw new SystemErrorException(ConstantMsg.SYAIN_NAME_LENGTH_ERROR);	
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR);
		}
		
		
	}
}
