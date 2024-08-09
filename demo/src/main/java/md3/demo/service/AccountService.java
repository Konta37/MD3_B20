package md3.demo.service;

import md3.demo.model.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    boolean save(Account account);
    Account findById(Integer id);
    Account login(String username, String password);
}
