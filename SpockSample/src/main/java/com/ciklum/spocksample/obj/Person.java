package com.ciklum.spocksample.obj;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author tsv@ciklum.com
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    private Role role;
    private Address address;
    private List<Account> accounts;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
