package com.ciklum.spocksample.obj;

import java.math.BigDecimal;

/**
 * @author tsv@ciklum.com
 */
public class Account {
    
    private String number;
    private BigDecimal rest;
    boolean main;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getRest() {
        return rest;
    }

    public void setRest(BigDecimal rest) {
        this.rest = rest;
    }

    public boolean isMain() {
        return main;
    }

    public void setIsMain(boolean isMain) {
        this.main = isMain;
    }
}
