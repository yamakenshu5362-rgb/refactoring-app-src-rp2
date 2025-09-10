package jp.co.sss.crud.io;

public class EmployeeGenderReader {
	public boolean isValid(String inputString) {
		return inputString.matches("^|[0129０１２９]{1}$");
	}
}
