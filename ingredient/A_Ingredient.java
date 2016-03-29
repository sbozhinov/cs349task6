package task6.ingredient;

import java.util.*;

import task6.money.Money;

public class A_Ingredient {

	private Money _cost;
	private String _description;
	private A_Ingredient _ingredientWrapped ;


	public A_Ingredient(Money cost,String description){
		_cost = cost;
		_description = description;
	}
	
	public A_Ingredient(Money cost,String description, A_Ingredient ingredientWrapped){
		_cost = cost;
		_description = description;
		_ingredientWrapped = ingredientWrapped;
	}
	
	public Money getCost(){
		return _cost;
	}
	
	public Money getCostTotal(){
		if(_ingredientWrapped == null){
			return _cost;
		}
	  
		return _cost.add(_ingredientWrapped.getCostTotal());		
	}
	
	public String getDescription(){
		return _description;
	}
	
	public List<String> getDescriptionTotal(){
		List<String> descriptionTotal = new LinkedList<String>();
		if(_ingredientWrapped == null){
			descriptionTotal.add(this.getDescription() );
			return descriptionTotal;
		}
		descriptionTotal.add(_description);

		descriptionTotal.addAll(_ingredientWrapped.getDescriptionTotal() );

		return descriptionTotal;
	
	}
	
	public List<A_Ingredient> getIngredients(){
		List<A_Ingredient> ingredientList = new LinkedList<A_Ingredient>();
		if(_ingredientWrapped == null){
			ingredientList.add(_ingredientWrapped );
			return ingredientList;
		}
		ingredientList.add(_ingredientWrapped);

		ingredientList.addAll(_ingredientWrapped.getIngredients() );

		return ingredientList;
		
	}
	
	public A_Ingredient getIngredientWrapped(){
		if(_ingredientWrapped == null)
			throw new RuntimeException("no next ingredient");
		return _ingredientWrapped;
		
	}
	public boolean hasIngredientWrapped(){
		if(_ingredientWrapped==null)
			return false;
		return true;
	}
	
	public String toString(){
		return  getClass().getSimpleName()+"{cost="+_cost.toString()+" description=["+_description+"]}";
	}
	
}
