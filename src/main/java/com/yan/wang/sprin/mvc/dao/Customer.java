package com.yan.wang.sprin.mvc.dao;

import java.io.Serializable;

/**
 * Created by ywang on 13.01.15.
 */
public class Customer implements Serializable {
    private int customer_id;
    private String email;

    public int getCustomer_id() {
        return customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
