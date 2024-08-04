package br.com.m4rc310.fc.registry.models;

import lombok.Getter;

@Getter
public enum EKindOperation {
	
	DEBIT(1),
	CREDIT(2),
	REVERSAL(3),
	DEBT_SETTLEMENT(4),
	CANCEL(5);
	
	private int operation;
	
	private EKindOperation(int operation) {
		this.operation = operation;
	}
}
