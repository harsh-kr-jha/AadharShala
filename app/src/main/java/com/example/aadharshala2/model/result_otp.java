package com.example.aadharshala2.model;

public class result_otp {
    private String status;
    private String token;
    private String error = null;

    public result_otp(String status, String token, String error) {
        this.status = status;
        this.token = token;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
