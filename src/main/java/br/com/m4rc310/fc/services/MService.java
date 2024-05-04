package br.com.m4rc310.fc.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.m4rc310.fc.data.repositories.TransactionCycleRepository;
import br.com.m4rc310.fc.data.repositories.TransactionRepository;

public class MService extends br.com.m4rc310.gql.services.MService {
	@Autowired
	protected TransactionCycleRepository transactionCycleRepository;
	
	@Autowired
	protected TransactionRepository transactionRepository;
	
	protected void validate(boolean pattern, String message, Object... args) throws Exception {
		if (pattern) {
			throw new Exception(message);
		}
	}
}
