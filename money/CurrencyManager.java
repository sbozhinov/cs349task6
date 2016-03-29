
package task6.money;
import java.util.*;

public class CurrencyManager {

	private int _centsProfit = 0;
	
	public CurrencyManager(){
		
	}
	
	public Money getExchangeProfit(){
		Money _profit = new Money(_centsProfit);
		return _profit;
	}
	
	public List<A_Currency>  makeChange(Money amount){
		
		LinkedList<A_Currency> change = new LinkedList<A_Currency>();
		int dollarsRemaining = amount.getDollars();
		int centsRemaining = amount.getCentsOfDollar();

		while(dollarsRemaining >0){
			
			if(dollarsRemaining %10 ==0 || dollarsRemaining>10){
				dollarsRemaining-=10;
				change.add(new CurrencyPaperDollar_10() );
			}
			else if(dollarsRemaining %5 ==0 || dollarsRemaining>5){				
				change.add(new CurrencyPaperDollar_5() );
				dollarsRemaining-=5;
			}
			else if(dollarsRemaining %2 ==0 || dollarsRemaining>2){				
				change.add(new CurrencyPaperDollar_2() );
				dollarsRemaining -= 2;
			}
			else if(dollarsRemaining %1 ==0){				
				change.add(new CurrencyPaperDollar_1() );
				dollarsRemaining-=1;
			}

		}
		
		//cents
		while(centsRemaining>0){
			if(centsRemaining %25 ==0 || centsRemaining>25){				
				centsRemaining-=25;
				change.add(new CurrencyCoinCent_25() );
			}
			else if(centsRemaining %10 ==0 || centsRemaining>10){
				centsRemaining-=10;
				change.add(new CurrencyCoinCent_10() );
			}
			else if(centsRemaining %5 ==0 || centsRemaining>5){
				centsRemaining-=5;
				change.add(new CurrencyCoinCent_5() );
			}
			else{
				_centsProfit+=centsRemaining;
				break;
			}
			
		}
		

		return change;
		
	}
	
	public Money sumCurrency(List<A_Currency> denominations){
		Money _sumCurrency = new Money();
		for (A_Currency den: denominations) {
			_sumCurrency.add(den.getValue());
		}
		return _sumCurrency;
	}
	
	
}
