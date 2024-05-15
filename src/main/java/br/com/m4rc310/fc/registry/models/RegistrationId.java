package br.com.m4rc310.fc.registry.models;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLEnumValue;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
//@AllArgsConstructor(staticName = "from")
@Embeddable
public class RegistrationId implements MConsts {
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = DISCRIMINATOR$registry)
	@GraphQLEnumValue(name = DISCRIMINATOR$registry, description = DESC$discriminator_registry)
	private ETypeRegistration type;
	
	@Column(name = CODE$registration)
	@GraphQLQuery(name = CODE$registration, description = DESC$code_registration)
	private Long code;
}
