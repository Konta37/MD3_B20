package md3.demo.service;

import md3.demo.model.entity.Account;
import md3.demo.repository.AccountRepository;
import md3.demo.repository.impl.AccountRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account login(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }
}
