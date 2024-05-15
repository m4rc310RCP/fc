package br.com.m4rc310.fc.registry.models;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = MConsts.TYPE$person_juridical)
@GraphQLType(name = MConsts.TYPE$person_juridical)
@DiscriminatorValue("2")
public class PersonJuridical extends Person {

}
