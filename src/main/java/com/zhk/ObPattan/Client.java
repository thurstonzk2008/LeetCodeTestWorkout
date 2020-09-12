package com.zhk.ObPattan;

import java.util.Arrays;

/**
 * @author zhuhk
 * @create 2020-06-24 4:03 下午
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        UserController userController = new UserController();
        RegNotificationObserver regNotificationObserver = new RegNotificationObserver();
        RegPromotionObserver regPromotionObserver = new RegPromotionObserver();

        userController.setRegObservers(Arrays.asList(regNotificationObserver, regPromotionObserver));
       // regNotificationObserver.handleRegSuccess();
        userController.register();
    }
}
