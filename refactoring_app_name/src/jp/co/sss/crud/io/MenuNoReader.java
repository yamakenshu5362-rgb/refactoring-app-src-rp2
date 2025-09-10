package jp.co.sss.crud.io;

public class MenuNoReader {

	public boolean isValid(String inputString) {
		return inputString.matches("^[1-7１-７]{1}$");
	}
}
