package com.yan.wang.sprin.mvc.dao;

import java.io.Serializable;

/**
 * Created by ywang on 13.01.15.
 */
public class CustomerVoucher implements Serializable {
    private int id;
    private int customer_id;
    private int voucher_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(int voucher_id) {
        this.voucher_id = voucher_id;
    }
}
