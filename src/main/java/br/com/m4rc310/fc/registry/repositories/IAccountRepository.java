package br.com.m4rc310.fc.registry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.m4rc310.fc.registry.models.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
	
}
