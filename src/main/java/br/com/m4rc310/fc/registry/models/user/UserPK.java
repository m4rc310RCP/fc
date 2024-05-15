package br.com.m4rc310.fc.registry.models.user;

import br.com.m4rc310.fc.registry.models.RegistrationId;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class UserPK {
	private RegistrationId registrationId;
	private UserId userId;
}