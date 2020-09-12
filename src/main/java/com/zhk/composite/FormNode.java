package com.zhk.composite;

/**
 * @author zhuhk
 * @create 2020-06-22 7:21 下午
 * @Version 1.0
 **/
public abstract class FormNode {
    private String text;
    public FormNode(String text) {
       this.text = text;
    }
    public String getText(){
        return text;
    }
    public void draw () {
        throw new UnsupportedOperationException();
    }
    public void add (FormNode formNode) {
        throw  new UnsupportedOperationException();
    }
}
