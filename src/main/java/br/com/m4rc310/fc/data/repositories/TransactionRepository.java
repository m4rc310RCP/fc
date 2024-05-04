package br.com.m4rc310.fc.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.m4rc310.fc.data.models.transactions.Transaction;
import br.com.m4rc310.fc.data.models.transactions.TransactionId;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {

	//List<Transaction> findAllByTransactionCycle(TransactionCycle tc);
	
}
