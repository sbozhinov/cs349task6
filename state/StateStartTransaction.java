package task6.state;

import task6.ingredient.*;
import task6.Transaction;
import task6.money.A_Currency;

public class StateStartTransaction extends A_State{

		
	public StateStartTransaction() {		
		super(new Transaction());
	}

	public StateReturnRefund doReturnRefund(){
		return null;
		
	}
	
	public StateBuildCoffeeBaseDecaf doSelectCoffeeBaseDecaf(){
		Transaction decaf = new Transaction();
		decaf = getTransaction();
		decaf.updateIngredientOuter(new IngredientBaseCoffeeDecaf());
		return new StateBuildCoffeeBaseDecaf(decaf);
	}
	
	public StateBuildCoffeeBaseRegular doSelectCoffeeBaseRegular(){
		Transaction cof = new Transaction();
		cof = getTransaction();
		cof.updateIngredientOuter(new IngredientBaseCoffeeRegular());
		return new StateBuildCoffeeBaseRegular(cof);
		
	}
	
	public void insertMoney(A_Currency denomination){
		getTransaction().addMoneyTendered(denomination);
	}
	
}
