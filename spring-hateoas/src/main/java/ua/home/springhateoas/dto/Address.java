package ua.home.springhateoas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
public class Address {

    @JsonIgnore
    private String id;

    private String street;

    private String apt;

    public Address() {
    }

    public Address(String id, String street, String apt) {
        this.id = id;
        this.street = street;
        this.apt = apt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }
}
