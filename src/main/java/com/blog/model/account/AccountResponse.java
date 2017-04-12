package com.blog.model.account;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by nasheikh on 4/8/17.
 */

public class AccountResponse {
        @ApiModelProperty(required = true, value = "")
        private List<Account> accounts;

        public List<Account> getAccounts() {
                return accounts;
        }

        public void setAccounts(List<Account> accounts) {
                this.accounts = accounts;
        }
}
