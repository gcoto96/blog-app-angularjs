package com.blog.api.account;

import com.blog.model.account.Account;
import com.blog.model.account.AccountResponse;
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
import java.util.List;


/**
 * Created by nasheikh on 4/8/17.
 */
@RestController
@RequestMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Accounts"})
public class AccountController {

    @RequestMapping("/healthcheck")
    public String healthCheck() {
        return "Blog App is Up!";
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private AccountRepo accountRepo;
    @ApiOperation(value = "List of products", response = AccountResponse.class)
    @RequestMapping(method = RequestMethod.GET)
    public List<Account> getProductsByPage(
            @ApiParam(value = ""    )               @RequestParam(value = "page"  ,  defaultValue="0"   ,  required = false) Integer page,
            @ApiParam(value = "between 1 to 1000" ) @RequestParam(value = "size"  ,  defaultValue="20"  ,  required = false) Integer size,
            @RequestParam(value = "productid"  , required = false) Integer accountId,
            @RequestParam(value = "category"   , required = false) String  category
    ) {
        AccountResponse resp = new AccountResponse();
        Account qry = new Account();
        if (accountId != null)  { qry.setId(accountId); }
         return accountRepo.findAll();

    }

    @RequestMapping(method = RequestMethod.POST)
    public Account addAccount(@RequestBody Account item) {
        item.setId(null);
        return accountRepo.saveAndFlush(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Account updateAccount(@RequestBody Account updatedAccount, @PathVariable Integer id) {
        updatedAccount.setId(id);
        return accountRepo.saveAndFlush(updatedAccount);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Integer id) {
        accountRepo.delete(id);
    }

//    @ApiOperation(value = "Add new product", response = OperationResponse.class)
//    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = {"application/json"})
//    public OperationResponse addNewProduct(@RequestBody Product product, HttpServletRequest req) {
//
//        OperationResponse resp = new OperationResponse();
//        System.out.println("ID:" + product.getId());
//        System.out.println("Name:" + product.getProductName());
//        System.out.println("Code:" + product.getProductCode());
//        System.out.println("Category:" + product.getCategory());
//
//        if (this.productRepo.exists(product.getId()) ){
//            resp.setOperationStatus(ResponseStatusEnum.ERROR);
//            resp.setOperationMessage("Unable to add Product - Product allready exist ");
//        }
//        else{
//            //Product addedProduct = this.productRepo.save(product);
//            this.productRepo.save(product);
//            resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
//            resp.setOperationMessage("Product Added");
//        }
//        return resp;
//    }
//
//    @ApiOperation(value = "Delete a product", response = OperationResponse.class)
//    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE, produces = {"application/json"})
//    public OperationResponse deleteProduct(@PathVariable("productId") Integer productId, HttpServletRequest req) {
//        OperationResponse resp = new OperationResponse();
//        if (this.productRepo.exists(productId) ){
//            this.productRepo.delete(productId);
//            resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
//            resp.setOperationMessage("Product Deleted");
//        }
//        else{
//            resp.setOperationStatus(ResponseStatusEnum.ERROR);
//            resp.setOperationMessage("No Product Exist");
//        }
//        return resp;
//    }


}