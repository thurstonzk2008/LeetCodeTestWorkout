package test.com.zhk.passwordencryption; 

import com.zhk.passwordencryption.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MD5CheckPassword Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 26, 2020</pre> 
* @version 1.0 
*/ 
public class MD5CheckPasswordTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: checkPW(String ID, String password, String encryptPassword) 
* 
*/ 
@Test
public void testCheckPW() throws Exception {
    String ID = "id1";
    String password = "password";
    String wrongPassword = "password1";
    Isalt mySalt = new Random16StringSalt();
    RepositoryMock repositoryMock = new RepositoryMock();
    MD5Encrypt md5Encrypt = new MD5Encrypt(mySalt);
    String enCryptPassword = md5Encrypt.encryptPassword(password);
    String salt = md5Encrypt.getSalt();
    repositoryMock.put(ID,enCryptPassword,salt);
    MD5CheckPassword md5CheckPassword = new MD5CheckPassword(repositoryMock);
    Assert.assertTrue(md5CheckPassword.checkPW(ID,password,repositoryMock.getPassword(ID)));
  //  Assert.assertTrue(md5CheckPassword.checkPW(ID,wrongPassword,repositoryMock.getPassword(ID)));
}


} 
