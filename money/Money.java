package task6.money;
//@author Stan Bozhinov
import java.util.*;

public class Money {
	private int _centsTotal;
	private boolean _isPositive;
	
	public Money(){
		_centsTotal = 0;
	}
	
	public Money(int cents){
		_centsTotal = cents;
	}
	
	public Money(int dollars, int cents){
		_centsTotal = (dollars*100)+cents;
	}
	
	public Money(int dollars, int cents, boolean isPositive){
		_centsTotal = (dollars*100)+cents;
		_isPositive = isPositive;
	}
	
	public Money add(Money money){
		_centsTotal += money.getCentsTotal();
		return this;		
	}
	
	public int compareTo(Money money){
		
		if( this.equals(money)==true)
			return 1;
		return 0;		
	}
	
	public int getCentsOfDollar(){
		return getCentsTotal()%100;
	}
	
	public int getCentsTotal(){
		return _centsTotal;
	}
	
	public int getDollars(){
		return (_centsTotal-getCentsOfDollar())/100;
	}
	
	public int hashCode(){
		return Objects.hash(getDollars(), getCentsOfDollar());
	}
	
	public boolean isNegative(){
		if(getCentsTotal()<0)
			return true;
		return false;		
	}
	
	public boolean isPositive(){
		if(getCentsTotal()>0)
			return true;
		return false;		
	}
	
	public boolean isZero(){
		if(getCentsTotal()== 0)
			return true;
		return false;		
	}
	
	public Money subtract(Money money){
		_centsTotal = _centsTotal - money.getCentsTotal();
		return this;		
	}
	
	public String toString(){
		return "$"+getDollars()+"."+getCentsOfDollar();
	}
	
}
