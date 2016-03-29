package task6.state;
import task6.ingredient.*;
import task6.Transaction;
import task6.ingredient.IngredientBaseCoffeeDecaf;

public class A_State {

	private Transaction _transaction;
	
	public A_State(Transaction transaction){
		_transaction = transaction;
	}
	public StateDeliverProduct doDeliverProduct() {
		
		return new StateDeliverProduct(_transaction);
	}
	
	public StateReturnRefund doReturnRefund(){
		return new StateReturnRefund(_transaction);
		
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
	
	public StateBuildCoffeeExtraCream doSelectExtraCream(){
		Transaction cream = new Transaction();
		cream = getTransaction();
		cream.updateIngredientOuter(new IngredientBaseCoffeeDecaf());
		return new StateBuildCoffeeExtraCream(cream);
	}
	
	public StateBuildCoffeeExtraMilk doSelectExtraMilk(){
		Transaction milk = new Transaction();
		milk = getTransaction();
		milk.updateIngredientOuter(new IngredientBaseCoffeeDecaf());
		return new StateBuildCoffeeExtraMilk(milk);
	}
	
	public StateBuildCoffeeExtraSugar doSelectExtraSugar(){
		Transaction sugar = new Transaction();
		sugar = getTransaction();
		sugar.updateIngredientOuter(new IngredientExtraSugar(sugar.getIngredientOuter() ));
		return new StateBuildCoffeeExtraSugar(sugar);
	}
	
	public StateStartTransaction doStartTransaction(){
		return new StateStartTransaction();
	}
	
	public Transaction getTransaction(){
		return _transaction;
	}
	
	public String toString(){
		return getClass().getSimpleName()+"{transaction="+_transaction.toString();
	}
	

}
