package br.com.m4rc310.fc.registry.models.user;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class UserId implements MConsts{
	@Column(name = NAME$username)
	@GraphQLQuery(name = NAME$username, description = DESC$name_username)
	private String username;	
}
