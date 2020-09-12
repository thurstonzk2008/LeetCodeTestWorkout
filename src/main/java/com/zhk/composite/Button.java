package com.zhk.composite;

/**
 * @author zhuhk
 * @create 2020-06-22 9:44 下午
 * @Version 1.0
 **/
public class Button extends FormNode {
    public Button(String text) {
        super(text);
    }

    @Override
    public void draw() {
        System.out.println("print Button(" + getText() + ")");
    }
}
