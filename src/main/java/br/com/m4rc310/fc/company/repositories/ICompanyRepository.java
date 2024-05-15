package br.com.m4rc310.fc.company.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.m4rc310.fc.company.models.Company;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long>{

	List<Company> findAllByCancelFalse();

}
