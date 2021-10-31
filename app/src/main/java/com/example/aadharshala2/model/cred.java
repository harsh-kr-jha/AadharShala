package com.example.aadharshala2.model;

public class cred {

    private String otp;
    private String token;

    public cred(String otp, String token) {
        this.otp = otp;
        this.token = token;

    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String status) {
        this.otp = otp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
