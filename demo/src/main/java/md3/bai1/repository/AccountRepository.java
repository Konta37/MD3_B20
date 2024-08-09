package md3.bai1.repository;

import md3.bai1.model.entity.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
    boolean save(Account account);
    Account findById(Integer id);
    Account findByUsernameAndPassword(String username, String password);
}
