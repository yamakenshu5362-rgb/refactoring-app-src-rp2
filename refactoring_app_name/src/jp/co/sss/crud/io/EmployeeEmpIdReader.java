package jp.co.sss.crud.io;

public class EmployeeEmpIdReader {
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-9１-９]{1}[0-9１-９]{0,3}$");
	}
}
