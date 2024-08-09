package md3.demo.repository;

import md3.demo.model.entity.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
    boolean save(Account account);
    Account findById(Integer id);
    Account findByUsernameAndPassword(String username, String password);
}
