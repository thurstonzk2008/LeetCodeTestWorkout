package com.zhk.passwordencryption;

/**
 * @author zhuhk
 * @create 2020-08-26 11:12 上午
 * @Version 1.0
 **/
public class MD5CheckPassword implements ICheckPassword {
    private RepositoryMock repositoryMock;
    public MD5CheckPassword (RepositoryMock repositoryMock) {
        this.repositoryMock = repositoryMock;
    }
    @Override
    public boolean checkPW(String ID, String password, String encryptPassword) {
        String salt = repositoryMock.getSalt(ID);
        String encryptPasswordc = HashUtil.md5(password + salt);

        return encryptPassword.equals(encryptPasswordc);
    }
}
