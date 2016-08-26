package ua.home.springhateoas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
public class Account {

    @JsonIgnore
    private String id;

    private String desc;

    private String number;

    public Account() {
    }

    public Account(String id, String desc, String number) {
        this.id = id;
        this.desc = desc;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
