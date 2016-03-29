package task6.state;

import task6.Transaction;
import task6.ingredient.IngredientBaseCoffeeDecaf;

public class A_StateBuildCoffeeBase extends A_State{

	public A_StateBuildCoffeeBase(Transaction transaction){
		super(transaction);
	}
	
    public StateDeliverProduct doDeliverProduct() {
		
		return new StateDeliverProduct(getTransaction());
	}
	
	public StateReturnRefund doReturnRefund(){
		return new StateReturnRefund(getTransaction());
		
	}
	
	
	public StateBuildCoffeeExtraCream doSelectExtraCream(){
		Transaction cream = new Transaction();
		cream = getTransaction();
		cream.updateIngredientOuter(new IngredientBaseCoffeeDecaf());
		return new StateBuildCoffeeExtraCream(cream);
	}
	
	public StateBuildCoffeeExtraMilk doSelectExtraMilk(){
		return null;
	}
	
	public StateBuildCoffeeExtraSugar doSelectExtraSugar(){
		return null;
	}
}
