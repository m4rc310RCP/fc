package br.com.m4rc310.fc.data.models.documents;

import java.io.Serializable;

import br.com.m4rc310.fc.services.MConsts;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "${type.document}")
@GraphQLType(name = "${type.document}", description = "${desc.type.document}")
public class Document implements Serializable, MConsts {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private DocumentId id;
}
