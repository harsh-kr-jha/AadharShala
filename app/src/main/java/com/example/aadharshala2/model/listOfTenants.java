package com.example.aadharshala2.model;

import java.util.List;

public class listOfTenants {
    private String status;
    private List<tenant> tenants;
    private String errCode = null;


    public listOfTenants(String status, List<tenant> tenants, String errCode) {
        this.status = status;
        this.tenants = tenants;
        this.errCode = errCode;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<tenant> getList() {
        return tenants;
    }

    public void setList(List<String> list) {
        this.tenants = tenants;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

}
