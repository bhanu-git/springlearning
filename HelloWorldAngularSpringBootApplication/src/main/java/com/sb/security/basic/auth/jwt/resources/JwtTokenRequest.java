package com.sb.security.basic.auth.jwt.resources;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;

//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU4MzY3ODIwOCwiaWF0IjoxNTgzMDczNDA4fQ.E2931EZ-Jr6ZuotjtPiopF0KxfLRZ08w8Kc_quAjZwev0BIRuHS_Vbja5AIwcnLizNaDqpZIL_DXR0gY4DE0gA"
//    }
    
    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

