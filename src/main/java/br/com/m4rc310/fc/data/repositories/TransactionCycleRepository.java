package br.com.m4rc310.fc.data.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.m4rc310.fc.data.models.transactions.TransactionCycle;

@Repository
public interface TransactionCycleRepository extends JpaRepository<TransactionCycle, Long> {
	Optional<TransactionCycle> findByDateCloseNull();
	Optional<TransactionCycle> findByDateCloseNullOrDateCloseAfter(Date now);
}
