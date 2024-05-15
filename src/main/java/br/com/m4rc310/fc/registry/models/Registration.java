package br.com.m4rc310.fc.registry.models;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = MConsts.TYPE$registration)
@GraphQLType(name = MConsts.TYPE$registration, description = MConsts.DESC$type_registration)
public class Registration implements MConsts{
	
	@EmbeddedId
	private RegistrationId id;
	
	@Column(name = NUMBER$vd , precision = 1, scale = 0)
	@GraphQLQuery(name = NUMBER$vd, description = DESC$number_vd)
	private Integer vd; 
}
