package bank;

public class Shinhan extends Bank {
	String showBalance() {
		
		
			this.setMoney((int)(this.getMoney()*0.5));
			return super.showBalance();
	}


}