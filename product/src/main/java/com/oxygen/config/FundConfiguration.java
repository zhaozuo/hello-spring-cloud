package com.oxygen.config;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 配置单个微服务（优先级3）
@Configuration
public class FundConfiguration {
    @Bean
    public IRule rule() {
        return new BestAvailableRule();
    }
    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }
}
