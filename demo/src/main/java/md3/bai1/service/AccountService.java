package md3.bai1.service;

import md3.bai1.model.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    boolean save(Account account);
    Account findById(Integer id);
    Account login(String username, String password);
}
