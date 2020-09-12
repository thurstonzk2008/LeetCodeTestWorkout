package com.zhk.composite;

/**
 * @author zhuhk
 * @create 2020-06-22 9:44 下午
 * @Version 1.0
 **/
public class LinkLable extends FormNode {
    public LinkLable(String text) {
        super(text);
    }

    @Override
    public void draw() {
        System.out.println("print LinkLable(" + getText() + ")");
    }
}
