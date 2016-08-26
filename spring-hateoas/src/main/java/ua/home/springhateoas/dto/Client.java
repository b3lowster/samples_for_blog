package ua.home.springhateoas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
public class Client {

    @JsonIgnore
    private String id;

    private String firstName;

    private String secondName;

    @JsonIgnore
    private String accountId;

    @JsonIgnore
    private String addressId;

    public Client() {
    }

    public Client(String id, String firstName, String secondName, String accountId, String addressId) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountId = accountId;
        this.addressId = addressId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
