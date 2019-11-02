package cn.ssm.exception;

public class MyException extends Exception {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MyException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MyException{" +
				"msg='" + msg + '\'' +
				'}';
	}
}
