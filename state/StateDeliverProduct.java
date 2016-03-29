package task6.state;

import task6.Transaction;


public class StateDeliverProduct extends A_State{

	
	public StateDeliverProduct(Transaction transaction){
		super(transaction);
	}
	
	public StateReturnChange doReturnChange(){
		Transaction doChange = new Transaction();
		doChange = getTransaction();
		return new StateReturnChange(doChange);
				
	}
	
}
