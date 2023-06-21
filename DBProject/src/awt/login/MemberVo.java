package awt.login;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

public class MemberVo {
	private String id;
	private String password;
	private String accountnumber;

	public MemberVo() {

	}

	public MemberVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

}