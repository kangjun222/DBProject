package q0608;

import java.sql.*;

public class OracleInsert {

	public static void main(String[] args) {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="c##himedia";
		String password="himedia";
		
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success");
			Connection conn=DriverManager.getConnection(ur1,user,password);
			System.out.println("oracle connection success.\n");
			
			  Statement stmt = conn.createStatement();
			  
			  String sql="SELECT * FROM dept";
			  ResultSet rs=stmt.executeQuery(sql);
					    while(rs.next()) {
			                System.out.print(rs.getString("deptno") + " ");
			                System.out.print(rs.getString("dname") + " ");
			                System.out.println(rs.getString("loc") + " ");
			            }
			            
			        } catch (ClassNotFoundException e) {
			            System.out.println("jdbc driver loading fail.");
			            e.printStackTrace();
			        } catch (SQLException e) {
			            System.out.println("oracle connection fail.");
			            e.printStackTrace();
			        }
			    }

		
		
	}


