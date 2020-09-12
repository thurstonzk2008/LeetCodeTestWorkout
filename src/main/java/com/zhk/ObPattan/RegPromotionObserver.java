package com.zhk.ObPattan;

/**
 * @author zhuhk
 * @create 2020-06-24 3:57 下午
 * @Version 1.0
 **/
public class RegPromotionObserver {
    @Subscribe
    public void handleRegSuccess(Long userId) {
        System.out.println("handlePromotion userId = " + userId);
    }
}
