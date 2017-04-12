package com.blog.repository.account;

import com.blog.model.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nasheikh on 4/8/17.
 */

public interface AccountRepo extends JpaRepository<Account, Integer> {
    public List<Account> findAll();
    public Page<Account> findAll(Pageable p);
 //   Optional<Account> findOneById(Integer id);

    //Product save(Product p);
    //void delete(Product p) ;
    //void delete(Integer id);
    //Product deleteById(Integer id);
    //boolean exists( Integer id);
}