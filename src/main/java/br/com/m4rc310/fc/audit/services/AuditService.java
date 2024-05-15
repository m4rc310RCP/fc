package br.com.m4rc310.fc.audit.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.m4rc310.fc.services.IAudit;
import br.com.m4rc310.fc.services.MConsts;
import br.com.m4rc310.gql.mappers.annotations.MDate;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class AuditService implements MConsts {

	@MDate
	@GraphQLQuery(name = DATE$audit, description = DESC$date_audit)
	public Date dateAudit(@GraphQLContext IAudit iAudit) {
		try {
			return iAudit.getAudit().getDateCreated();
		} catch (Exception e) {
			return null;
		}
	}
	
	@MDate
	@GraphQLQuery(name = DATE$last_update, description = DESC$date_last_update)
	public Date dateLastUpdate(@GraphQLContext IAudit iAudit) {
		try {
			return iAudit.getAudit().getDateLastUpdate();
		} catch (Exception e) {
			return null;
		}
	}

}
