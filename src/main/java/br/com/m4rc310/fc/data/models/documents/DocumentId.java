package br.com.m4rc310.fc.data.models.documents;

import java.io.Serializable;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DocumentId implements Serializable, MConsts {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "${number.document}")
	@GraphQLQuery(name = "${number.document}", description = "${desc.number.document}")
	private Long number;
	
	@Column(name = "${identify.serie}")
	@GraphQLQuery(name = "${identify.serie}", description = "${desc.identify.serie}")
	private String serie;
}
