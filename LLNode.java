package com.mitchellf.stmNumberOne;

import org.multiverse.api.StmUtils;
import org.multiverse.api.references.TxnInteger;
import org.multiverse.api.references.TxnLong;

public class LLNode {
	
	/*
	 * 	This version of the class exists to demonstrate what runtime would look like without 
	 * 		any implemented access permissions, and as such values must be written/read to/from 
	 * 		within getter/setter methods and in transactions/atomic blocks
	 * 
	 * 
	 * 
	 * 	Uses "multiverse" STM Library
	 * 
	 */
	
	private TxnInteger value;
	 
	public LLNode(int value) {
		 this.value = StmUtils.newTxnInteger(value);
	}
	
	//Sets the value.  Must be performed in an atomic block 
	public void setValue(int amount) {
	    StmUtils.atomic(() -> {
	        value.increment(amount);	 
	        if (value.get() <= 0) {
	            throw new IllegalArgumentException("Not enough money");
	        }
	    });
	}
	
	public Integer getValue() {
	    return value.atomicGet();
	}
	
	
	

}
