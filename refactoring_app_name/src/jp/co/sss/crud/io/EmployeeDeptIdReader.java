package jp.co.sss.crud.io;

public class EmployeeDeptIdReader {
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-3１-３]{1}$");
	}
}
