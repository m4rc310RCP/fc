package br.com.m4rc310.fc.data.models.transactions;

import java.math.BigDecimal;

import br.com.m4rc310.fc.data.models.documents.Document;
import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "${type.transaction}")
@GraphQLType(name = "${type.transaction}", description = "${desc.type.transaction}")
public class Transaction implements MConsts{
	
	@EmbeddedId
	@GraphQLIgnore
	private TransactionId id;
	
	@ManyToOne
	@JoinColumns(value = {
		@JoinColumn(name = NUMBER$document),
		@JoinColumn(name = IDENTIFY$serie)
	})
	@GraphQLIgnore
	private Document document;
	
	@Column(name = "${type.operation}")
@GraphQLIgnore
	private ETypeOperation  typeOperation;
	
	@Column(name = "${value.transaction}")
	@GraphQLQuery(name = "${value.transaction}", description = "${desc.value.transaction}")
	private BigDecimal value;
}
