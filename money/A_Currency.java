package task6.money;
//@author Stan Bozhinov
import java.util.*;

public abstract class A_Currency implements Comparable<A_Currency>{

	private Money _currentAmount;
	private String _description;
	private A_Currency _A_CurrencyAmount;
	private int _changeCents;
	public A_Currency(Money money, String description){
		_currentAmount = money;
		_description = description;	
	}

	
	public int compareTo(A_Currency money) {
		
		if( this.getValue().equals(money.getValue()) == true){
			return 1;
		}
		return 0;
	}
	
	public Money add(A_Currency amount){
		_currentAmount.add(amount.getValue());
		return _currentAmount;		
	}
	
	public Money add(Money amount){
		_currentAmount.add(amount);
		return _currentAmount;
	}
	
	
	public String getDescription(){
		return _description;
	}
	
	public Money getValue(){
		return _currentAmount;
	}
	
	public Money subtract(A_Currency amount){
		return _currentAmount;	
	}
	
	public Money subtract(Money amount){
		return amount;	
	}
	
	public String toString(){
		return _currentAmount.toString()+"/"+_description;
	}
	
	public int hashCode(){
		return Objects.hash(getValue(), getDescription());
	}
}
