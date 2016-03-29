package task6.state;


import java.util.List;

import task6.Transaction;
import task6.money.A_Currency;
import task6.money.CurrencyManager;

public class StateReturnRefund extends A_State{

	public StateReturnRefund(Transaction transaction){
		super(transaction);
		List<A_Currency> temp = makeChange();
		System.out.println("[MACHINE] refunded");
		for(A_Currency a: temp)
			System.out.println(a.toString() );
	
		
	}
	
	List<A_Currency> makeChange(){
		CurrencyManager mana = new CurrencyManager();
		return mana.makeChange( getTransaction().getMoneyTendered());

	}
}
