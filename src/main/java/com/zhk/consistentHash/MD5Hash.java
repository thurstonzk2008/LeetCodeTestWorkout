package com.zhk.consistentHash;

/**
 * @author zhuhk
 * @create 2020-07-06 7:21 下午
 * @Version 1.0
 **/
public class MD5Hash implements Ihash {
    @Override
    public int hash(String o) {
        return HashUtil.md5(o).hashCode();
    }
}
