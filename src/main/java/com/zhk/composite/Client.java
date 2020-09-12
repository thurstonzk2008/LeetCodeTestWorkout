package com.zhk.composite;

/**
 * @author zhuhk
 * @create 2020-06-23 11:28 上午
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        WinForm winForm = new WinForm("WINDOWS窗口");
        Picture picture = new Picture("LOGO图片");
        Button button = new Button("登录");
        Button button1 = new Button("注册");
        Frame frame = new Frame("FRAME1");
        Lable lable = new Lable("用户名");
        TextBox textBox = new TextBox("文本框");
        Lable lable1 = new Lable("密码");
        PasswordBox passwordBox = new PasswordBox("密码框");
        CheckBox checkBox = new CheckBox("复选框");
        TextBox textBox1 = new TextBox("记住用户名");
        LinkLable linkLable = new LinkLable("忘记密码");
        winForm.add(picture);
        winForm.add(button);
        winForm.add(button1);
        winForm.add(frame);
        frame.add(lable);
        frame.add(textBox);
        frame.add(lable1);
        frame.add(passwordBox);
        frame.add(checkBox);
        frame.add(textBox1);
        frame.add(linkLable);
        winForm.draw();


    }
}
