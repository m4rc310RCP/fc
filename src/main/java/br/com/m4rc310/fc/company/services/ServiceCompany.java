package br.com.m4rc310.fc.company.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.m4rc310.fc.company.models.Company;
import br.com.m4rc310.fc.services.MService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class ServiceCompany extends MService {

//	***************    QUERIE'S    ***************  //
	@GraphQLQuery(name = QUERY$company, description = DESC$query_company)
	public Company getCompany(@GraphQLArgument(name = CODE$company, description = DESC$code_company) Long code) {
		return companyRepository.findById(code).orElse(null);
	}

	@GraphQLQuery(name = QUERY$all_companies, description = DESC$query_all_companies)
	public List<Company> listCompanies() {
		return companyRepository.findAll();
	}

//	***************   MUTATION'S   ***************  //
	@GraphQLMutation(name = MUTATION$company, description = DESC$mutation_company)
	public Company setCompany(
			@GraphQLArgument(name = ARGUMENT$company, description = DESC$argument_company) Company company)
			throws Exception {

		Long code = company.getCode();
		
		if (code != null) {
			Company c = companyRepository.findById(code).orElse(null);
			//c.setCode(code);
			if (c == null) {
				company.setCancel(false);
			} else {
				flux.cloneAtoB(c, company);
			}
		} else {
			company.setCancel(false);
		}
		
		company.setCode(code);
		
		registerAudit(company);
		
		return companyRepository.save(company);
	}

	@GraphQLMutation(name = MUTATION$cancel_company, description = DESC$mutation_cancel_company)
	public Company cancelCompany(@GraphQLArgument(name = CODE$company, description = DESC$code_company) Long code)
			throws Exception {
		Company c = companyRepository.findById(code).orElse(null);
		if (c == null) {
			return null;
		}
		c.setCancel(true);

		registerAudit(c);

		return companyRepository.saveAndFlush(c);
	}

//	*************** SUBSCRIPTION'S ***************  //
}
