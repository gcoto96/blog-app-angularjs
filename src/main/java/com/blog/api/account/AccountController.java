package com.blog.api.account;

import com.blog.model.account.Account;
//import AccountRepo;
import com.blog.repository.account.AccountRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by nasheikh on 4/9/17.
 * Class Name: AccountController
 * Description: REST controller for all accounts related workflow
 */
@RestController
@RequestMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Accounts"})
public class AccountController {

 /*
   Method Name: healthCheck
   Description : This method is to check app health
   Input Param : NA
   Output Type: HTTP.OK
 */
    @RequestMapping("/healthcheck")
    public String healthCheck() {
        return "Blog App is Up!";
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private AccountRepo accountRepo;

//TODO multi user accounts feature (current code only has single user session)
//
//    @ApiOperation(value = "List of accounts", response = AccountResponse.class)
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Account> getAllAccounts(
//    ) {
//        AccountResponse resp = new AccountResponse();
//        Account qry = new Account();
//         return accountRepo.findAll();
//
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Account addAccount(@RequestBody Account item) {
//        item.setId(null);
//        return accountRepo.saveAndFlush(item);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Account updateAccount(@RequestBody Account updatedAccount, @PathVariable Integer id) {
//        updatedAccount.setId(id);
//        return accountRepo.saveAndFlush(updatedAccount);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void deleteAccount(@PathVariable Integer id) {
//        accountRepo.delete(id);
//    }


}
