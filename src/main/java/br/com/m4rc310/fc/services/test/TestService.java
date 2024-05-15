package br.com.m4rc310.fc.services.test;

import org.springframework.stereotype.Service;

import br.com.m4rc310.fc.services.MService;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class TestService extends MService {
	
	@GraphQLQuery(name = QUERY$test, description = DESC$query_test)
	public String test() {
		return "OK";
	}
}
