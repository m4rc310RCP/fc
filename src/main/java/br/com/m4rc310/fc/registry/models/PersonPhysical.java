package br.com.m4rc310.fc.registry.models;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = MConsts.TYPE$person_physical)
@GraphQLType(name = MConsts.TYPE$person_physical)
@DiscriminatorValue("1")
public class PersonPhysical extends Person {

}
