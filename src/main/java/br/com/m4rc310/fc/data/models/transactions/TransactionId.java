package br.com.m4rc310.fc.data.models.transactions;

import java.io.Serializable;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class TransactionId implements Serializable, MConsts {
	private static final long serialVersionUID = 1L;

	@Column(name = NUMBER$sequence)
	@GraphQLQuery(name = NUMBER$sequence, description = DESC$number_sequence)
	private Long sequence;
	
	@ManyToOne
	@JoinColumn(name = NUMBER$transaction)
	@GraphQLIgnore
	private TransactionCycle transactionCycle;
}
