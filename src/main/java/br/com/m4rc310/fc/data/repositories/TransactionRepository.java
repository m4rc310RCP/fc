package br.com.m4rc310.fc.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.m4rc310.fc.data.models.transactions.Transaction;
import br.com.m4rc310.fc.data.models.transactions.TransactionCycle;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findAllByTransactionCycle(TransactionCycle tc);
	
}
