package br.com.m4rc310.fc.registry.models;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity(name = MConsts.TYPE$person)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = MConsts.DISCRIMINATOR$person, discriminatorType = DiscriminatorType.INTEGER)
public class Person implements MConsts {

	@Id
	@Column(name = NUMBER$cc, length = 14)
	@GraphQLQuery(name = NUMBER$cc, description = DESC$number_cc)
	private String numberCpfCnpj;
}
