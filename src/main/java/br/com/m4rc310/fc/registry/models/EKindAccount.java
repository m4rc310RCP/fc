package br.com.m4rc310.fc.registry.models;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLEnumValue;
import lombok.Getter;

@Getter
public enum EKindAccount {
	@GraphQLEnumValue(name = MConsts.DISCRIMINATOR$account_debit, description = MConsts.DESC$discriminator_account_debit)
	DEBIT(0),
	@GraphQLEnumValue(name = MConsts.DISCRIMINATOR$account_credit, description = MConsts.DESC$discriminator_account_credit)
	CREDIT(1);
	
	private int kind;

	private EKindAccount(int kind) {
		this.kind = kind;
	}
}
