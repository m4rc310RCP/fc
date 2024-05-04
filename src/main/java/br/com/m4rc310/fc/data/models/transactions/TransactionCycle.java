package br.com.m4rc310.fc.data.models.transactions;

import java.util.Date;

import br.com.m4rc310.fc.services.MConsts;
import br.com.m4rc310.gql.mappers.annotations.MDate;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Entity(name = "${type.transaction.cycle}")
@GraphQLType(name = "${type.transaction.cycle}", description = "${desc.type.transaction.cycle}")
public class TransactionCycle implements MConsts{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "${number.transaction}")
	@GraphQLQuery(name = "${number.transaction}", description = "${desc.number.transaction}")
	private Long number;

	@Column(name = "${date.open}")
	@Temporal(TemporalType.TIMESTAMP)
	@MDate("dd/MM/yyyy HH:mm:ss")
	@GraphQLQuery(name = "${date.open}", description = "${desc.date.open}")
	private Date dateOpen;
	
	@Column(name = "${date.close}")
	@Temporal(TemporalType.TIMESTAMP)
	@MDate("dd/MM/yyyy HH:mm:ss")
	@GraphQLQuery(name = "${date.close}", description = "${desc.date.close}")
	private Date dateClose;
	
	
}
