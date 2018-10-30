package com.mitchellf.stmNumberOne;

import org.multiverse.api.Lock;
import org.multiverse.api.Stm;
import org.multiverse.api.StmUtils;
import org.multiverse.api.Txn;
import org.multiverse.api.TxnObject;
import org.multiverse.api.TxnThreadLocal;
import org.multiverse.api.references.TxnInteger;
import org.multiverse.api.references.TxnLong;

/*
This class represents a Node in a linked list, specifically for the ReadHeavyTest.  
 This node represents a node in a linked list with "Immutable" permission, and as such does not 
 contain a "setValue" method, because the value field can not be modified, and does not contain a 
 getValue method, because the value does not need to be "opened for reading", as no other Thread 
 has the ability to modify its value.
 */

public class LLNodeImmutable {
	
	// Fields are made public so that they can be accessed without using getter methods.  
	//  In these examples, the use of a getter method represents "open for read" and a setter method 
	//	represents "open for write".  
	// 
	public Integer value;
	
	//The object is created, and all fields in the object can be accessed directly once created, 
	// because in practice, they cannot be modified.  Because they will never be modified,
	//  the read does not need to be performed in a transaction.
	public LLNodeImmutable(int value) {
		this.value = value;
	}
		
}
