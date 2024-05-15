package br.com.m4rc310.fc;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.m4rc310.fc.registry.models.ETypeRegistration;
import br.com.m4rc310.fc.registry.models.PersonPhysical;
import br.com.m4rc310.fc.registry.models.RegistrationId;
import br.com.m4rc310.fc.registry.models.user.User;
import br.com.m4rc310.fc.registry.models.user.UserId;
import br.com.m4rc310.fc.registry.models.user.UserPK;
import br.com.m4rc310.fc.registry.repositories.IPersonPhysicalRepository;
import br.com.m4rc310.fc.registry.services.CachedService;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@PropertySource(ignoreResourceNotFound = true, value = "classpath:/security.properties")
public class App {

	@Autowired
	private CachedService cachedUserService;

	@Autowired
	private IPersonPhysicalRepository personPhysicalRepo;

	@Autowired
	private PasswordEncoder pe;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));

//		UserId userId = UserId.from("test");
		UserId userId = new UserId();
		userId.setUsername("test");

		if (cachedUserService.getUserFromUsername(userId.getUsername()) == null) {
			RegistrationId registrationId = new RegistrationId();
			registrationId.setCode(1L);
			registrationId.setType(ETypeRegistration.USER);

			UserPK pk = new UserPK();
			pk.setRegistrationId(registrationId);
			pk.setUserId(userId);

			User user = new User();
			user.setPk(pk);
			user.setPassword(pe.encode("test"));
			user.setRoles("Admin".split(";"));

			PersonPhysical pp = personPhysicalRepo.findById("00000000000").orElse(new PersonPhysical());
			pp.setNumberCpfCnpj("00000000000");
			pp = personPhysicalRepo.save(pp);

			user.setPerson(pp);

			cachedUserService.storeUser(user);
		}
	}

}
