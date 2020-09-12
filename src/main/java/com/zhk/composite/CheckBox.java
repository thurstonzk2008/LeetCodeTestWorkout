package com.zhk.composite;

/**
 * @author zhuhk
 * @create 2020-06-22 9:44 下午
 * @Version 1.0
 **/
public class CheckBox extends FormNode {
    public CheckBox(String text) {
        super(text);
    }

    @Override
    public void draw() {
        System.out.println("print CheckBox(" + getText() + ")");
    }
}
