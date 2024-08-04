package br.com.m4rc310.fc.registry.services;

import java.math.BigDecimal;
import java.util.List;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.m4rc310.fc.audit.models.Audit;
import br.com.m4rc310.fc.registry.models.Account;
import br.com.m4rc310.fc.registry.models.Movto;
import br.com.m4rc310.fc.registry.models.RegistrationId;
import br.com.m4rc310.fc.registry.models.user.User;
import br.com.m4rc310.fc.registry.models.user.UserId;
import br.com.m4rc310.fc.services.IAudit;
import br.com.m4rc310.fc.services.MService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class RegistryService extends MService {

	@Autowired
	private CachedService cachedService;

	private static final String FLUX_ACCOUNT = "flux_account";

	@GraphQLQuery(name = CODE$registration, description = DESC$code_registration)
	public Long registry(@GraphQLContext IAudit iaudit) {
		try {
			return getRegistraction(iaudit).getCode();
		} catch (Exception e) {
			return null;
		}
	}

	@GraphQLQuery(name = DISCRIMINATOR$registry, description = DESC$discriminator_registry)
	public Integer type(@GraphQLContext IAudit iaudit) {
		try {
			return getRegistraction(iaudit).getType().getCode();
		} catch (Exception e) {
			return null;
		}
	}

	@GraphQLQuery(name = NAME$username, description = DESC$name_username)
	public String username(@GraphQLContext IAudit iaudit) {
		return getUserId(iaudit).getUsername();
	}

	private RegistrationId getRegistraction(IAudit iaudit) {
		Audit audit = iaudit.getAudit();
		User user = audit.getUser();
		return user.getPk().getRegistrationId();
	}

	private UserId getUserId(IAudit iaudit) {
		Audit audit = iaudit.getAudit();
		User user = audit.getUser();
		return user.getPk().getUserId();
	}

	@GraphQLQuery(name = QUERY$consumption_accounts, description = DESC$query_consumption_accounts)
	public List<Account> listAccounts() {
		return cachedService.listAccounts();
	}

	@GraphQLQuery(name = QUERY$consumption_account, description = DESC$query_consumption_account)
	public Account getAccount(@GraphQLArgument(name = NUMBER$account, description = DESC$number_account) Long number) {
		return cachedService.getAccount(number);
	}

	//
	@GraphQLMutation(name = MUTATION$consumption_account, description = DESC$mutation_consumption_account)
	public Account store(
			@GraphQLArgument(name = ARGUMENT$consumption_account, description = DESC$argument_consumption_account) Account account) {
		return cachedService.storeAccount(account);
	}

	@GraphQLMutation(name = MUTATION$cancel_consumption_account, description = DESC$mutation_cancel_consumption_account)
	public Account cancel(@GraphQLArgument(name = NUMBER$account, description = DESC$number_account) Long number) {
		return cachedService.cancelAccount(number);
	}

	@GraphQLMutation(name = MUTATION$add_movto, description = DESC$mutation_add_movto)
	public List<Movto> addMovto(@GraphQLArgument(name = NUMBER$movto, description = DESC$number_movto) Long numberValue,
			@GraphQLArgument(name = NUMBER$account, description = DESC$number_account) Long numberAccount,
			@GraphQLArgument(name = VALUE$movto, description = DESC$value_movto) BigDecimal value) throws Exception {

		List<Movto> movto = cachedService.addMovto(numberValue, numberAccount, value );
		
		String id = String.format("%s_%d", FLUX_ACCOUNT, numberAccount);
		flux.callPublish(Account.class, id, getAccount(numberAccount));
		
		return movto;
	}
	
	@GraphQLQuery(name = LIST$movtos, description = DESC$list_movtos)
	public List<Movto> listMovto(@GraphQLContext Account account){
		return cachedService.getListMovto(account.getNumber());
	}
	
	@GraphQLQuery(name = VALUE$balance, description = DESC$value_balance)
	public BigDecimal balance(@GraphQLContext Account account){
		BigDecimal balance = BigDecimal.ZERO;
		List<Movto> moviments = cachedService.getListMovto(account.getNumber());
		for (Movto movto : moviments) {
			balance = balance.add(movto.getValue());
		}
		return balance;
	}
	
	
	@GraphQLSubscription(name = SUBSCRIPTION$account, description = DESC$subscription_account)
	public Publisher<Account> registerAccountListener(
			@GraphQLArgument(name = NUMBER$account, description = DESC$number_account) Long numberAccount) {
		String id = String.format("%s_%d", FLUX_ACCOUNT, numberAccount);
		return flux.publish(Account.class, id, getAccount(numberAccount));
	}
	

//	public Flux<List<Movto>> registerMovtoListener(
//			@GraphQLArgument(name = NUMBER$account, description = DESC$number_account) Long numberAccount) {
//		String id = String.format("%s_%d", FLUX_ACCOUNT, numberAccount);
//		List<Movto> movtoDefault = cachedService.getListMovto(numberAccount);
//		return flux.publishList(Movto.class, id, movtoDefault);
//	}

}
