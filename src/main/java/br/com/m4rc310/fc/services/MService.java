package br.com.m4rc310.fc.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.m4rc310.fc.data.repositories.TransactionCycleRepository;
import br.com.m4rc310.fc.data.repositories.TransactionRepository;
import br.com.m4rc310.gql.messages.MMessageBuilder;

public class MService extends br.com.m4rc310.gql.services.MService {
	@Autowired
	protected TransactionCycleRepository transactionCycleRepository;
	
	@Autowired
	protected TransactionRepository transactionRepository;
	
	@Autowired
	private MMessageBuilder messageBuilder;
	
	protected void validate(boolean pattern, String message, Object... args) throws Exception {
		if (pattern) {
			throw new Exception(getMessage(message, args));
		}
	}
	
	protected String getMessage(String key, Object... args) {
		return messageBuilder.getMessage(key, args);
	}
	
	protected Exception getException(String message, Object... args) {
		return new Exception(getMessage(message, args));
	}
	
	
	
}
