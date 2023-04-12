package com.oxygen.product.facade.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.oxygen.common.vo.ResultMessage;
import com.oxygen.product.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class UserFacadeImpl implements UserFacade {
    // 注入RestTemplate，在Ribbon中我们标注了@LoadBalance，用以实现负载均衡
    @Resource
    private RestTemplate restTemplate = null;

    @Override
    // @HystrixCommand将方法推给Hystrix进行监控
    // 配置项fallbackMethod指定了降级服务的方法
    @HystrixCommand(
            fallbackMethod = "fallback1",
            commandProperties = {
                @HystrixProperty(name = "execution.timeout.enabled", value = "true")
            },
            threadPoolProperties = {
                @HystrixProperty(name = "hystrix.threadpool.default.coreSize", value = "10")
            }
    )
    public ResultMessage timeout() {
        String url = "http://USER/hystrix/timeout";
        return restTemplate.getForObject(url, ResultMessage.class);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback2")
    public ResultMessage exp(String msg) {
        String url = "http://USER/hystrix/exp/{msg}";
        return restTemplate.getForObject(url, ResultMessage.class, msg);
    }

    // 降级方法1
    public ResultMessage fallback1 () {
        return new ResultMessage(false, "超时了");
    }

    /**
     * 降级方法2，带有参数
     *
     * @param msg 消息
     * @return 结果消息
     * @author 王兆祚
     * @since 2023-03-22 21:40
     */
    public ResultMessage fallback2 (String msg) {
        return new ResultMessage(false, "调用产生异常了，参数：" + msg);
    }
}
