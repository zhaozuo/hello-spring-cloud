package com.oxygen.user.controller;

import com.oxygen.common.vo.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {
    private static final Long MAX_SLEEP_TIME = 5000L;

    /**
     * 随机超时测试，触发服务消费者启用断路器
     *
     * @author 王兆祚
     * @since 2023-03-21 21:27
     */
    @GetMapping("/timeout")
    public ResultMessage timeout() {
        // 产生一个小于5000的长整型随机数
        long sleepTime = (long) (MAX_SLEEP_TIME * Math.random());
        try {
            // 线程按一个随机数字休眠，使得服务消费者能够存在一定的概率产生熔断
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            System.out.println("执行异常");
        }
        return new ResultMessage(true, "执行时间" + sleepTime);
    }

    /**
     * 异常测试，触发服务消费者启用断路
     *
     * @author 王兆祚
     * @since 2023-03-21 22:13
     */
    @RequestMapping("/exp/{msg}")
    public ResultMessage exp(@PathVariable("msg") String msg) {
        if ("spring".equals(msg)) {
            return new ResultMessage(true, msg);
        } else {
            // 触发异常，让服务消费者启用熔断
            throw new RuntimeException("出现了异常，请检查参数msg是否为spring");
        }
    }
}
