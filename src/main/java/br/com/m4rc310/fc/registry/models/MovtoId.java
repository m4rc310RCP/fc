package br.com.m4rc310.fc.registry.models;

import java.io.Serializable;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class MovtoId implements MConsts, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = NUMBER$movto)
	@GraphQLQuery(name = NUMBER$movto, description = DESC$number_movto)
	private Long number;
	
	@Column(name = NUMBER$sequence)
	@GraphQLQuery(name = NUMBER$sequence, description = DESC$number_sequence)
	private Integer sequence;

}
