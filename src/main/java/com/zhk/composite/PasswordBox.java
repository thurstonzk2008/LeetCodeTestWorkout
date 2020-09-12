package com.zhk.composite;

/**
 * @author zhuhk
 * @create 2020-06-22 9:44 下午
 * @Version 1.0
 **/
public class PasswordBox extends FormNode {
    public PasswordBox(String text) {
        super(text);
    }

    @Override
    public void draw() {
        System.out.println("print PasswordBox(" + getText() + ")");
    }
}
