package br.com.m4rc310.fc.audit.models;

import java.io.Serializable;
import java.util.Date;

import br.com.m4rc310.fc.registry.models.user.User;
import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity(name = MConsts.TYPE$audit)
@GraphQLType(name = MConsts.TYPE$audit, description = MConsts.DESC$type_audit)
public class Audit implements MConsts, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CODE$audit)
	@GraphQLQuery(name = CODE$audit, description = DESC$code_audit)
	private Long code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = DATE$audit)
	@GraphQLQuery(name = DATE$audit, description = DESC$date_audit)
	private Date dateCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = DATE$last_update)
	@GraphQLQuery(name = DATE$last_update, description = DESC$date_last_update)
	private Date dateLastUpdate;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = DISCRIMINATOR$registry, referencedColumnName = DISCRIMINATOR$registry),
		@JoinColumn(name = CODE$registration, referencedColumnName = CODE$registration),
		@JoinColumn(name = NAME$username, referencedColumnName = NAME$username),
		
	})
	@GraphQLIgnore 
	private User user;
}
