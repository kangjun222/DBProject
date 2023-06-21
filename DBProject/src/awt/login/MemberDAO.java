package awt.login;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##himedia";
	String password = "himedia";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private Connection con1;
	private ResultSet as;
	private Statement stmt2;

	
	
	public ArrayList<MemberVo> list(String id) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM member";
			if (id != null) {
				query += " where id=TRIM('" + id + "')";

			}
			System.out.println("29 -- SQL :" + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow():" + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + "rows selected.....");
				rs.previous();
				while (rs.next()) {
					String sh = rs.getString("id");
					String password = rs.getString("password");

					MemberVo data = new MemberVo(sh, password);
					list.add(data);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	public Statement getStmt() {
		return stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public Connection getCon1() {
		return con1;

	}

	public ResultSet getAs() {
		return as;
	}

	public Statement getStmt2() {
		return stmt2;
	}

}
