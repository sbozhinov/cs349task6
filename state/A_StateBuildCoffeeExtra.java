package task6.state;

import task6.Transaction;
import task6.ingredient.IngredientExtraSugar;

public class A_StateBuildCoffeeExtra extends A_State{
	private Transaction _transaction;
	public A_StateBuildCoffeeExtra(Transaction transaction){
		super(transaction);
	}
	
    public StateDeliverProduct doDeliverProduct() {
		
		return new StateDeliverProduct(_transaction);
	}
	
	public StateReturnRefund doReturnRefund(){
		return new StateReturnRefund(_transaction);
		
	}
	
	
	public StateBuildCoffeeExtraCream doSelectExtraCream(){
		return null;
	}
	
	public StateBuildCoffeeExtraMilk doSelectExtraMilk(){
		return null;
	}
	
	public StateBuildCoffeeExtraSugar doSelectExtraSugar(){
		Transaction sugar = new Transaction();
		sugar = getTransaction();
		sugar.updateIngredientOuter(new IngredientExtraSugar(sugar.getIngredientOuter() ));
		return new StateBuildCoffeeExtraSugar(sugar);
	}
}
