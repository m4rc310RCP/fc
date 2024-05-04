package br.com.m4rc310.fc.data.models.transactions;

import java.math.BigDecimal;

import org.hibernate.annotations.Type;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "${type.transaction}")
@GraphQLType(name = "${type.transaction}", description = "${desc.type.transaction}")
public class Transaction implements MConsts{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "${number.sequence}")
	@GraphQLQuery(name = "${number.sequence}", description = "${desc.number.sequence}")
	private Long sequence;
	
	@ManyToOne
	@JoinColumn(name = NUMBER$transaction)
	private TransactionCycle transactionCycle;
	
	@Column(name = "${value.transaction}")
	@GraphQLQuery(name = "${value.transaction}", description = "${desc.value.transaction}")
	private BigDecimal value;
}
