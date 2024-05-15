package br.com.m4rc310.fc.registry.models;

import java.io.Serializable;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = MConsts.TYPE$consumption_account)
@GraphQLType(name = MConsts.TYPE$consumption_account, description = MConsts.DESC$type_consumption_account)
public class Account implements MConsts, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name=NUMBER$account, length = 10)
	@GraphQLQuery(name = NUMBER$account, description = DESC$number_account)
	private Long number;

	@Column(name=DISCRIMINATOR$account, length = 300)
	@GraphQLQuery(name = DISCRIMINATOR$account, description = DESC$discriminator_account)
	private String discriminator;
	
	@Column(name = KIND$account)
	@GraphQLQuery(name = KIND$account, description = DESC$kind_account)
	private EKindAccount kindAccount;
	
	@Column(name = INDICATOR$cancel)
	@GraphQLQuery(name = INDICATOR$cancel, description = DESC$indicator_cancel)
	private Boolean cancel;
}
