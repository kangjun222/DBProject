package q06082;

import java.util.ArrayList;

public class MenberTest {

	public static void main(String[] args) {
		MemberDAO dao=new MemberDAO();
		ArrayList<MemberVo>list =dao.list();
		
		for(int i=0; i<list.size(); i++) {
			MemberVo data=(MemberVo)list.get(i);
			String empno =data.getEmpno();
			String ename=data.getEname();
			int sal=data.getSal();
			int comm=data.getComm();
			
			System.out.println(empno+" : "+ename+" : "+" : "+sal+":"+comm+" "+(sal+comm));
			
		}
		
	}

}
