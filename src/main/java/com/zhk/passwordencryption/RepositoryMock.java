package com.zhk.passwordencryption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryMock {
    private Map<String,Map<String,String>> respority = new HashMap<>();
    public void put (String ID,String Password,String salt) {
        Map<String,String> pwAndsalt = new HashMap<>();
        pwAndsalt.put("Password",Password);
        pwAndsalt.put("salt",salt);
        respority.put(ID,pwAndsalt);
    }
    public String getPassword(String ID) {
        return respority.get(ID).get("Password");
    }
    public String getSalt(String ID){
        return respority.get(ID).get("salt");
    }
}
