package br.com.m4rc310.fc.registry.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.m4rc310.fc.registry.models.RegistrationId;
import br.com.m4rc310.fc.registry.models.user.User;
import br.com.m4rc310.fc.registry.models.user.UserId;
import br.com.m4rc310.fc.registry.models.user.UserPK;

@Repository
public interface IUserRepository extends JpaRepository<User, UserPK> {
	Optional<User> findByPkUserId(UserId userId);
	Optional<User> findByPkRegistrationId(RegistrationId registrationId);
}
