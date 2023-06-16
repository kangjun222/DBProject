package bank;

public class Hana extends Bank {
	
	@Override
	boolean withdraw(int money) {
		money *=1.5;
		return super.withdraw(money);
	}

}
