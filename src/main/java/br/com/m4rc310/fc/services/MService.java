package br.com.m4rc310.fc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.m4rc310.fc.audit.models.Audit;
import br.com.m4rc310.fc.company.repositories.ICompanyRepository;
import br.com.m4rc310.fc.registry.models.user.User;
import br.com.m4rc310.fc.registry.models.user.UserId;
import br.com.m4rc310.fc.registry.repositories.IAccountRepository;
import br.com.m4rc310.fc.registry.repositories.IMovtoRepository;
import br.com.m4rc310.fc.registry.repositories.IRegistryRepository;
import br.com.m4rc310.fc.registry.repositories.IUserRepository;
import br.com.m4rc310.gql.dto.MUser;
import br.com.m4rc310.gql.messages.MMessageBuilder;

public class MService extends br.com.m4rc310.gql.services.MService implements MConsts {

	@Autowired
	protected ICompanyRepository companyRepository;

	@Autowired
	protected IRegistryRepository registryRepository;
	
	@Autowired
	protected IUserRepository userRepository;
	
	@Autowired
	protected IAccountRepository accountRepository;
	
	@Autowired
	protected IMovtoRepository movtoRepository;
	
	

	@Autowired
	private MMessageBuilder messageBuilder;

	protected void validate(boolean pattern, String message, Object... args) throws Exception {
		if (pattern) {
			throw new Exception(getMessage(message, args));
		}
	}

	protected String getMessage(String key, Object... args) {
		return messageBuilder.getMessage(key, args);
	}

	protected Exception getException(String message, Object... args) {
		return new Exception(getMessage(message, args));
	}

	protected void registerAudit(IAudit iaudit) throws Exception {
		Audit audit = new Audit();
		if (iaudit.getAudit() == null) {
			audit.setDateCreated(new Date());
			iaudit.setAudit(audit);
		} else {
			audit = iaudit.getAudit();
			audit.setDateLastUpdate(new Date());
		}

		MUser user = flux.getUser();
		if (user != null) {
			UserId userId = new UserId();
			userId.setUsername(user.getUsername());
			User u = userRepository.findByPkUserId(userId).orElseThrow(() -> getException(ERROR$user_not_found, user.getCode()));
			audit.setUser(u);		
		}
	}

}
