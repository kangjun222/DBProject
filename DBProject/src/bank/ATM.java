package bank;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Scanner;

//


public class ATM extends WindowAdapter implements ActionListener{


	
	
		
	
	
	//
	public static void main(String[] args) {
		
		
		

		
		
	
		//은행선택 >메인메뉴
		String msg="1.준형은행\n2.웅기은행\n3.우철은행\n4.나가기";
		
		
		
		String menu="1.계좌 개설\n2.입금하기\n3.출금하기\n4.잔액조회\n5.계좌번호 찾기\n6.은행다시선택";
		String name=null, account=null,phone=null,pw=null;
		int money=0;
		
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		Bank user=null;
		
		int bankChoice=0;
		int choice=0;
		
		while(true) {
			System.out.println(msg);
			bankChoice=sc.nextInt();
			
			if(bankChoice==4) {
				break;
			}
			while(true) {
				System.out.println(menu);
				choice=sc.nextInt();
				
				if(choice==6) {
					break;
				}
			
			switch(choice) {
			case 1://계좌개설
			Bank[] arBank= {new Hana(), new kookmin(), new Shinhan()};
			//6자리 랜덤 계좌번호
			
			while(true) {
				//정수>000000>0
				//100000~999999 중 하나의 계좌번호 생성
				
				account=r.nextInt(999999)+ 1 +"";
				for(int i=0; i<6-account.length(); i++) {
					account="0"+account;
					
				}
				if(Bank.checkAccount(account)==null) {
					break;
				}
			}
			account=bankChoice-1+account;
			arBank[bankChoice-1].setAccount(account);
			
			System.out.print("예금주:");
			name=sc.next();
			arBank[bankChoice-1].setName(name);
			
			while(true) {
				System.out.print("핸드폰 번호['-'제외]:");
				phone=sc.next();
				int i=0;
				for(i=0; i<phone.length(); i++) {
					char c=phone.charAt(i);
					if(c<48||c>57) {
						break;
					}
				}
				if(i==phone.length()) {
					if(phone.length()!=10 &&phone.length()!=11) {
						System.out.println("핸드폰 번호를 입력하세요");
						continue;
					}
					if(Bank.checkPhone(phone)==null) {
						break;
					}else {
						System.out.println("중복된 핸드폰 번호입니다");
					}
				}else {
					System.out.println("숫자만 입력하세요");
					}
				}
			arBank[bankChoice-1].setPhone(phone);
			
			
			while(true) {
				System.out.print("4자리 비밀번호");
				pw=sc.next();
				int i=0;
				for(i=0; i<pw.length(); i++) {
					char c=pw.charAt(i);
					if(c<48||c>57) {
						break;
						
					}
				}
				if(i==pw.length()) {
					if(pw.length()==4) {
						break;
					}else {
						System.out.println("4자리만 입력해주세요");
					}
				}else {
					System.out.println("숫자만 입력해주세요");
				}
			}
			arBank[bankChoice-1].setPw(pw);
			
			System.out.println("*****계좌가 계설되었습니다*******");
			System.out.println(name+"님의 계좌번호:"+account);
			System.out.println("계좌번호는 다시 못알려줍니다 숙지하세요!");
			
			
			
			
			Bank.arrBank[bankChoice-1][Bank.arCnt[bankChoice-1]]=arBank[bankChoice-1];
			Bank.arCnt[bankChoice-1]++;
			break;
			
			case 2://입금
				System.out.print("계좌 번호:");
				account=sc.next();
				if(account.charAt(0)-48!=bankChoice-1) {
					System.out.println("계좌를 개설한 은행에서만 입금을 도와드릴수있습니다");
					break;
					
				}
				System.out.print("비밀번호:");
				pw=sc.next();
				
				user=Bank.login(account, pw);
				if(user !=null) {
					System.out.print("입금액:");
					if(user.deposit(sc.nextInt())) {
						System.out.println("입금되었습니다");
						System.out.println(user.getName()+"님의 잔액:"+user.getMoney()+"원");
					}else {
						System.out.println("ERROE 001 입력한금액오류");
					}
				}else {
					System.out.println("ERROR 002 계좌번호 또는 비밀번호 오류");
					}
				break;
				
			case 3://출금
				System.out.print("계좌번호");
				account =sc.next();
				System.out.print("비밀번호:");
				pw=sc.next();
				
				user=Bank.login(account, pw);
				if(user!=null) {
					System.out.print("출금액:");
					
					money=sc.nextInt();
					if(money<=0) {
						System.out.println("Error001 입력한 금액오류"); 
						continue;
					}
					if(user.withdraw(money)) {
						System.out.println("출금 되었습니다");
						System.out.println(user.getName()+"님의 잔액:"+user.getMoney()+"원");
					}else {
						System.out.println("Error 002 잔액부족");
					}
				}else {
					System.out.println("Error 004 계좌또는 비밀번호 오류");
				}
				break;
			case 4://잔액조회
				System.out.println("계좌번호:");
				account=sc.next();
				System.out.print("비밀번호:");
				pw=sc.next();
				user=Bank.login(account, pw);
				if(user!=null) {
					System.out.println(user.showBalance());
				}else {
					System.out.println("ERROR 004 계좌번호 또는 비밀번호 오류");
				}
				break;
			case 5:
				System.out.print("핸드폰 번호:");
				phone=sc.next();
				user=Bank.checkPhone(phone);
				if(user==null) {
					System.out.println("잘못된 핸드폰 번호입니다");
					continue;
				}
				System.out.print("비밀번호");
				pw=sc.next();
				if(user.getPw().equals(pw)) {
					while(true) {
						account=r.nextInt(999999)+1+"";
						for(int i=0; i<6-account.length(); i++) {
							account="0"+account;
						}
						if(Bank.checkAccount(account)==null) {
							break;
						}
					}
					account=bankChoice-1+account;
					user.setAccount(account);
					System.out.println(user.getName()+"님의 새로운 계좌번호:"+account);
					System.out.println("!계좌번호는 다시 알려드리기 힘듭니다!");
					
				}
				break;
				default:
					System.out.println("다시 시도해주세요");
					break;
					
						}
					}
			}
			
			
			}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
		
