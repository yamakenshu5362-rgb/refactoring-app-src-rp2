package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeBirthdayReader{
	public boolean isValid(String inputString) throws IllegalInputException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);

		try {
			sdf.parse(inputString);
		} catch (ParseException e) {
			throw new IllegalInputException(ConstantMsg.MSG_SYSTEM_ERROR);
		}
		
		return true;

	}
}
