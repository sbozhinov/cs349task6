package task6.state;
import java.util.*;
import task6.Transaction;
import task6.money.A_Currency;
import task6.money.CurrencyManager;

public class StateReturnChange extends A_State{

	public StateReturnChange(Transaction transaction){
		super(transaction);
		List<A_Currency> temp = makeChange();
		System.out.println("[MACHINE] returned");
		for(A_Currency a: temp)
			System.out.println(a.toString() );
	}
	
	List<A_Currency> makeChange(){
		CurrencyManager manag = new CurrencyManager();
		return manag.makeChange( getTransaction().getMoneyTendered());

	}
}
