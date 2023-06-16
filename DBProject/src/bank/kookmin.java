package bank;

public class kookmin extends Bank {
	boolean depisit(int money) {
		money *=1.5;
		return super.withdraw(money);
		
	}

}
