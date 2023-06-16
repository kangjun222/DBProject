package bank;

public class Bank {
	//모든 은행의 고객을 관리하는 DB
	public static Bank[][] arrBank=new Bank[3][100];
	public static int[] arCnt=new int[arrBank.length];
	public static int  bank_num=-1; // 준형:0 웅기:1 우철:2
	
	
	private String name;
	private String account;
	private String phone;
	private String pw;
	private int money;
	   public Bank() {;}

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getAccount() {
	      return account;
	   }

	   public void setAccount(String account) {
	      this.account = account;
	   }

	   public String getPhone() {
	      return phone;
	   }

	   public void setPhone(String phone) {
	      this.phone = phone;
	   }

	   public String getPw() {
	      return pw;
	   }

	   public void setPw(String pw) {
	      this.pw = pw;
	   }

	   public int getMoney() {
	      return money;
	   }

	   public void setMoney(int money) {
	      this.money = money;
	   }
	   
	   //계좌번호 중복검사
	   public static Bank checkAccount(String account) {
	      Bank user = null;
	      int j = 0;
	      for (int i = 0; i < arrBank.length; i++) {
	         for (j = 0; j < arCnt[i]; j++) {
	            if(arrBank[i][j].account.equals(account)) {
	               bank_num = i;
	               user = arrBank[i][j];
	               break;
	            }
	         }
	         if(j != arCnt[i]) {break;}
	      }
	      return user;
	   }
	   //핸드폰번호 검사
	   public static Bank checkPhone(String phone) {
	      Bank user = null;
	      int j = 0;
	      for (int i = 0; i < arrBank.length; i++) {
	         for (j = 0; j < arCnt[i]; j++) {
	            if(arrBank[i][j].phone.equals(phone)) {
	               user = arrBank[i][j];
	               break;
	            }
	         }
	         if(j != arCnt[i]) {break;}
	      }
	      return user;
	   }
	   //로그인(계좌번호와 비밀번호)
	   public static Bank login(String account, String pw) {
	      Bank user = checkAccount(account);
	      //계좌번호가 있다면
	      if(user != null) {
	         //비밀번호 비교
	         if(user.pw.equals(pw)) {
	            return user;
	         }
	      }
	      return user;
	   }
	   //입금(입금액)
	   boolean deposit(int money) {
	      if(money <= 0) {return false;}
	      
	      this.money += money;
	      return true;
	   }
	   //출금(출금액, 잔액검사)
	   boolean withdraw(int money) {
	      if(this.money - money < 0) {return false;}
	      this.money -= money;
	      return true;
	   }
	   //잔액조회(msg를 String으로 리턴)
	   String showBalance() {
	      String temp = null;
	      String str = "계좌번호 : " + this.account + "\n"
	            + "예금주 : " + this.name + "\n"
	            + "현재 잔액 : " + this.money + "원";
	      
	      //하나 : 0, 국민 : 1, 신한 : 2
	      switch(bank_num) {
	      case 0:
	         temp = "하나 은행";
	         break;
	      case 1:
	         temp = "국민 은행";
	         break;
	      case 2:
	         temp = "신한 은행";
	         break;
	      }
	      
	      str = "은행명 : " + temp + "\n" + str;
	      
	      return str;
	   }
	}