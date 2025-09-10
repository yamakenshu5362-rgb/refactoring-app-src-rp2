package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception{

	public SystemErrorException(String msg){
		super(msg);
	}

	public SystemErrorException(String msgSystemError, Exception e) {
		super(msgSystemError);
	}
}
