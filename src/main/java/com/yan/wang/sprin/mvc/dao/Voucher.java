package com.yan.wang.sprin.mvc.dao;

import java.io.Serializable;

/**
 * Created by ywang on 13.01.15.
 */
public class Voucher implements Serializable {
    private int voucher_id;
    private String voucher_text;
    private String company_name;
    private int flag;

    public int getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(int voucher_id) {
        this.voucher_id = voucher_id;
    }

    public String getVoucher_text() {
        return voucher_text;
    }

    public void setVoucher_text(String voucher_text) {
        this.voucher_text = voucher_text;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
