package com.example.aadharshala2;

public class result {



        private String status;
        private String token;
        private String username;






        public void results(String status, String token, String username) {
            this.status = status;
            this.username = username;
            this.token = token;
            
        }

        public String getStatus() {
            return status;
        }
        
        public String getToken() {
        return token;

        }

        public String getUsername() {
        return username;
    }

        public void setUsername(String username) {
        this.username = username;
    }
    }





