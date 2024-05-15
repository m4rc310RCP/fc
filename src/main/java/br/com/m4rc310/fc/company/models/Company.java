package br.com.m4rc310.fc.company.models;

import java.io.Serializable;

import br.com.m4rc310.fc.audit.models.Audit;
import br.com.m4rc310.fc.services.IAudit;
import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = MConsts.TYPE$company)
@GraphQLType(name = MConsts.TYPE$company, description = MConsts.DESC$type_company)
public class Company implements Serializable, MConsts, IAudit {

	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CODE$company)
	@GraphQLQuery(name = CODE$company, description = DESC$code_company)
	private Long code;

	@Column(name = NAME$company, length = 100)
	@GraphQLQuery(name = NAME$company, description = DESC$name_company)
	private String name;
	
	@Column(name = INDICATOR$cancel)
	@GraphQLQuery(name = INDICATOR$cancel, description = DESC$indicator_cancel)
	private Boolean cancel;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = CODE$audit)
	@GraphQLIgnore
	private Audit audit;
	
	
}
