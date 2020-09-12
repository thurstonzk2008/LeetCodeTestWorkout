package com.zhk.ObPattan;

//import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executor;

/**
 * @author zhuhk
 * @create 2020-06-24 3:22 下午
 * @Version 1.0
 **/

public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
