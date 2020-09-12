package com.zhk.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuhk
 * @create 2020-06-22 8:19 下午
 * @Version 1.0
 **/
public class Frame extends FormNode {
    private List<FormNode> list = new ArrayList<>();

    public Frame(String text) {
        super(text);
    }

    @Override
    public void draw() {
        System.out.println("Print Frame(" + getText() + ")");
        for (FormNode fn : list) {
            fn.draw();
        }
    }

    @Override
    public void add(FormNode formNode) {
        list.add(formNode);
    }
}
