package com.example.aadharshala2.model;

import android.widget.Button;

public class tenant {


    private String reqCode;

    public tenant(String reqCode) {
        this.reqCode= reqCode;
    }


    public String getReqCode(){
        return  reqCode;

    }

    public String setReqCode(String reqCode){
        return this.reqCode= reqCode;
    }

}
