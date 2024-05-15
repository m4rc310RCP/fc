package br.com.m4rc310.fc.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.m4rc310.fc.registry.models.user.User;
import br.com.m4rc310.fc.registry.models.user.UserPK;
import br.com.m4rc310.fc.registry.services.CachedService;
import br.com.m4rc310.gql.MUserProvider;
import br.com.m4rc310.gql.dto.MUser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableCaching
public class SecurityConfig {

	@Autowired
	@Lazy
	private CachedService cachedUserService;

	@Autowired
	@Lazy
	private PasswordEncoder encoder;

	// @Bean
	MUser loadUserTest() {
		MUser user = new MUser();
		user.setUsername("test");
		user.setPassword("test");
		user.setRoles("admin".split(";"));
		return user;
	}

	@Bean
	@Lazy
	MUserProvider loadUserProvider() {
		return new MUserProvider() {

			@Override
			public MUser authUser(String username, Object password) throws Exception {
				MUser user = getUserFromUsername(username);

				if (encoder.matches(String.valueOf(password), user.getPassword())) {
					return user;
				}

				throw new Exception("User error!");
			}

			@Override
			@Cacheable("username")
			public MUser getUserFromUsername(String username) {
				User u = cachedUserService.getUserFromUsername(username);
				return mUserFromUser(u);
			}

			@Override
			public boolean isValidUser(MUser user) {
				log.info("isValidUser {}", user);
				return true;
			}
		};
	}

	private MUser mUserFromUser(User user) {
		try {
			UserPK pk = user.getPk();
			MUser u = new MUser();
			u.setCode(pk.getRegistrationId().getCode());
			u.setRoles(user.getRoles());
			u.setUsername(pk.getUserId().getUsername());
			u.setPassword(user.getPassword());
			return u;
		} catch (Exception e) {
			return null;
		}
	}

}