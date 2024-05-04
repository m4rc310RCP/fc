package br.com.m4rc310.fc.services.transactions;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.m4rc310.fc.data.models.transactions.Transaction;
import br.com.m4rc310.fc.data.models.transactions.TransactionCycle;
import br.com.m4rc310.fc.services.MConsts;
import br.com.m4rc310.fc.services.MService;
import br.com.m4rc310.gql.mappers.annotations.MDate;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class TransactionService extends MService implements MConsts {
	
	@GraphQLQuery(name=QUERY$transaction_cycle, description=DESC$query_transaction_cycle)
	public TransactionCycle findTransactionCycle() {
		return transactionCycleRepository.findByDateCloseNullOrDateCloseAfter(new Date()).orElse(null);
	}
	
	@GraphQLMutation(name=MUTATION$open_transaction_cycle, description=DESC$mutation_open_transaction_cycle)
	public TransactionCycle openTransactionCycle() throws Exception{
		validate(findTransactionCycle() != null, "${error.has.open.transaction.cycle}");
		
		TransactionCycle tc = new TransactionCycle();
		tc.setDateOpen(new Date());
		
		return transactionCycleRepository.saveAndFlush(tc);
	}
	
	@GraphQLMutation(name=MUTATION$close_transaction_cycle, description=DESC$mutation_close_transaction_cycle)
	public TransactionCycle closeTransactionCycle(
			@MDate @GraphQLArgument(name = DATE$close, description = DESC$date_close) Date date) throws Exception{
		TransactionCycle tc = transactionCycleRepository.findByDateCloseNullOrDateCloseAfter(new Date())
				.orElseThrow(()->getException("${error.no.active.transaction.cycle}"));
		
		validate(tc.getDateOpen().after(date), "${error.date.after.of.open.transaction.cycle}");
		
		tc.setDateClose(date);
		
		return transactionCycleRepository.saveAndFlush(tc);
	}
	
	@GraphQLMutation(name = "${mutation.register.debit}", description = "${desc.mutation.register.debit}")
	public TransactionCycle registerTransactionDebit(
			@GraphQLArgument(name = VALUE$transaction, description = DESC$value_transaction) 
			BigDecimal value) throws Exception {
		return storeTransaction(value, ETypeTransaction.DEBIT);
	}
	
	@GraphQLMutation(name = "${mutation.register.credit}", description = "${desc.mutation.register.credit}")
	public TransactionCycle registerTransactionCredit(
			@GraphQLArgument(name = VALUE$transaction, description = DESC$value_transaction) 
			BigDecimal value) throws Exception {
		return storeTransaction(value, ETypeTransaction.CREDIT);
	}
	
	private TransactionCycle storeTransaction(BigDecimal value, ETypeTransaction type) throws Exception{
		TransactionCycle tc = transactionCycleRepository.findByDateCloseNullOrDateCloseAfter(new Date())
				.orElseThrow(()->getException("${error.no.active.transaction.cycle}"));
		
		Transaction transaction = new Transaction();
		//transaction.setTransactionCycle(tc);
		
		value = value.abs();
		
		if (type == ETypeTransaction.DEBIT) {
			value = value.multiply(BigDecimal.valueOf(-1));
		}
		
		transaction.setValue(value);
		
		transactionRepository.saveAndFlush(transaction);
		return tc;
	}
	
	private enum ETypeTransaction{
		DEBIT, CREDIT
	}
	
	@GraphQLQuery(name = "${list.transactions}", description = "${desc.list.transactions}")
	public List<Transaction> listTransactions(@GraphQLContext TransactionCycle tc){
	//	return transactionRepository.findAllByTransactionCycle(tc);
		return null;
	}
	
	@GraphQLQuery(name = "${value.balance}", description = "${desc.value.balance}")
	public BigDecimal valueBalance(@GraphQLContext TransactionCycle tc){
		BigDecimal balance = BigDecimal.ZERO;
		for (Transaction t : listTransactions(tc)) {
			balance = balance.add(t.getValue());			
		}
		return balance;
	}
	
	
}
