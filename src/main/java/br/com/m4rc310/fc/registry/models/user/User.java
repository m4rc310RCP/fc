package br.com.m4rc310.fc.registry.models.user;

import java.io.Serializable;

import br.com.m4rc310.fc.registry.models.PersonPhysical;
import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = MConsts.TYPE$user)
@GraphQLType(name = MConsts.TYPE$user, description = MConsts.DESC$type_user)
public class User implements MConsts, Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@EmbeddedId
	private UserPK pk;
	
	
	@OneToOne
	@JoinColumn(name = NUMBER$cc)
	@GraphQLIgnore
	private PersonPhysical person;
	
	@Column(name = DISCRIMINATOR$password, length = 100)
	@GraphQLQuery(name = DISCRIMINATOR$password, description = DESC$discriminator_password)
	private String password;
	
	
	@Column(name = LIST$roles)
	private String[] roles;
}
