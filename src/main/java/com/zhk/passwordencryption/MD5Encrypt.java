package com.zhk.passwordencryption;

import java.security.MessageDigest;

/**
 * @author zhuhk
 * @create 2020-08-25 8:10 上午
 * @Version 1.0
 **/
public class MD5Encrypt implements Iencrypt{
    private Isalt mySalt;
    private String salt;
    public MD5Encrypt(Isalt isalt) {
        this.mySalt = isalt;
        salt = mySalt.salt();
    }
    public String  getSalt (){
        return salt;
    }
    @Override
    public String encryptPassword(String password) {
        return HashUtil.md5(password + getSalt());
    }
}
