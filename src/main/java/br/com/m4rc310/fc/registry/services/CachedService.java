package br.com.m4rc310.fc.registry.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import br.com.m4rc310.fc.registry.models.Account;
import br.com.m4rc310.fc.registry.models.EKindAccount;
import br.com.m4rc310.fc.registry.models.Movto;
import br.com.m4rc310.fc.registry.models.MovtoId;
import br.com.m4rc310.fc.registry.models.user.User;
import br.com.m4rc310.fc.registry.models.user.UserId;
import br.com.m4rc310.fc.services.MService;

@Service
@EnableCaching
public class CachedService extends MService{
	
	public static final String LOGIN_CACHE_KEY = "loginCache";
	public static final String ACCOUNT_CACHE_KEY = "accountCache";
	
	
	@Cacheable(value = LOGIN_CACHE_KEY, key = "#username")
	public User getUserFromUsername(String username) {
		UserId userId = new UserId();
		userId.setUsername(username);
		return userRepository.findByPkUserId(userId).orElse(null);
	}
	
	@CacheEvict(LOGIN_CACHE_KEY)
	public User storeUser(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	
	@Cacheable(value = ACCOUNT_CACHE_KEY)
	public List<Account> listAccounts(){
		return accountRepository.findAll();
	}
	
	@Cacheable(value = ACCOUNT_CACHE_KEY, key = "#number")
	public Account getAccount(Long number) {
		return accountRepository.findById(number).orElse(null);
	}
	
	@CacheEvict(value = ACCOUNT_CACHE_KEY, allEntries = true)
	public Account storeAccount(Account account) {
		if (account.getNumber()!=null) {
			flux.cloneAtoB(accountRepository.findById(account.getNumber()).orElse(account), account);
		}
		return accountRepository.save(account);
	}

	@CacheEvict(value = ACCOUNT_CACHE_KEY, key = "#number")
	public Account cancelAccount(Long number) {
		Account account = getAccount(number);
		if (movtoRepository.findAllByAccount(account).isEmpty()) {
			accountRepository.delete(account);
			return account;
		}
		account.setCancel(true);
		return accountRepository.save(account);
	}
	
	public List<Movto> getListMovto(Long number){
		return movtoRepository.findAllByIdNumber(number);
	}
	
	
	public List<Movto> addMovto(Long numberValue, Long numberAccount, BigDecimal value){
		int sequence = 0;
		List<Movto> list = getListMovto(numberValue);
		for (Movto movto : list) {
			if (sequence < movto.getId().getSequence()) {
				sequence = movto.getId().getSequence();
			}
		}
		
		Account account = getAccount(numberAccount);
		if (account.getKindAccount() == EKindAccount.DEBIT) {
			value = value.negate();
		}
		
		Movto movto = new Movto();
		movto.setAccount(account);
		movto.setValue(value);
		
		MovtoId id = movto.getId();
		id = id != null ? id : new MovtoId();
		id.setSequence(++sequence);
		id.setNumber(numberValue);
		movto.setId(id);
		
		movtoRepository.save(movto);
		
		list.add(movto);
		
		return list;
	}
	
	
}
