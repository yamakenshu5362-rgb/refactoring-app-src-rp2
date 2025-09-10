package jp.co.sss.crud.io;

public class EmployeeNameReader {
	public boolean isValid(String inputString) {
		
		if(!(inputString.length() >= 1 && 30 >= inputString.length())) {
			return true;
		}else {
			return false;
		}
			
	}
}
