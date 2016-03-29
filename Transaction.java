package task6;
import java.util.*;

import task6.ingredient.A_Ingredient;
import task6.money.*;


public class Transaction {

	private List <A_Ingredient> _ingredientList = new LinkedList <A_Ingredient>();
	private Money _currentBalance = new Money();
	protected A_Ingredient _ingredient;
	public Transaction(){
		
	}
	
	public Transaction(Money moneyTendered){
		_currentBalance = moneyTendered;
	}
	
	public Money addMoneyTendered(A_Currency money){
		_currentBalance.add(money.getValue() );
		return _currentBalance;
	}
	
	public A_Ingredient getIngredientOuter(){
		List <A_Ingredient> myList = new ArrayList<A_Ingredient>();
		myList = _ingredient.getIngredients();
		
		if(_ingredient.hasIngredientWrapped() != true)
			throw new RuntimeException("no outer ");
		
		A_Ingredient outer = myList.get(myList.size()-1);
		return outer;
		
	}
	
	public Money getMoneyTendered(){
		return _currentBalance;
	}
	
	public Money getProductCost(){
		Money costMoney = new Money();
		for(A_Ingredient ingredient : _ingredientList)
			costMoney.add(ingredient.getCost());
		return costMoney;
	}
	
	public boolean hasIngredientOuter(){
		if(_ingredient!= null)
			return 	_ingredient.hasIngredientWrapped();
		
		return false;
	}
	
	public String toString(){
		return  "moneyTendered="+_currentBalance.toString() 
				+ " ingredientOuter=" 
				+ getIngredientOuter();
		
	}
	
	public List<A_Ingredient> unrollProduct(){
		List<A_Ingredient> productList = new LinkedList<A_Ingredient>();
		for(A_Ingredient ing : _ingredient.getIngredients())
			productList.add(ing);
		return productList;
	}
	
	public void updateIngredientOuter(A_Ingredient ingredient){
	
		if(!hasIngredientOuter()) {
			
			_ingredient = ingredient;
			_currentBalance.subtract(ingredient.getCost());
	}
		else{			
			_ingredientList = _ingredient.getIngredients();
			_ingredientList.add(ingredient);
		}
		
	}
}
