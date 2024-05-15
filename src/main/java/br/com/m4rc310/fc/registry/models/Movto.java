package br.com.m4rc310.fc.registry.models;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = MConsts.TYPE$movto)
@GraphQLType(name = MConsts.TYPE$movto, description = MConsts.DESC$type_movto)
public class Movto implements MConsts, Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@GraphQLIgnore
	private MovtoId id;
	
	@ManyToOne
	@JoinColumn(name = NUMBER$account)
	@GraphQLIgnore
	private Account account;
	
	@Column(name = VALUE$movto)
	@GraphQLQuery(name=VALUE$movto, description =  DESC$value_movto)
	private BigDecimal value;
	
	@GraphQLQuery(name = NUMBER$account, description = DESC$number_account)
	public Long numberAccount(@GraphQLContext Movto movto) {
		try {
			return movto.getAccount().getNumber();			
		} catch (Exception e) {
			return null;
		}
	}
	@GraphQLQuery(name = NUMBER$sequence, description = DESC$number_sequence)
	public Integer numberSequence(@GraphQLContext Movto movto) {
		try {
			return id.getSequence();			
		} catch (Exception e) {
			return null;
		}
	}
}
