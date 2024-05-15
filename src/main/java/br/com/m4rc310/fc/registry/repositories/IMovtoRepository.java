package br.com.m4rc310.fc.registry.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.m4rc310.fc.registry.models.Account;
import br.com.m4rc310.fc.registry.models.Movto;
import br.com.m4rc310.fc.registry.models.MovtoId;

@Repository
public interface IMovtoRepository extends JpaRepository<Movto, MovtoId> {
	List<Movto> findAllByIdNumber(Long number);

	List<Movto> findAllByAccount(Account account);
}
