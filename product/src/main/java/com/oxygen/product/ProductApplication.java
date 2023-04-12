package com.oxygen.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    /**
     * 创建Spring Bean，使用负载均衡
     * @author 王兆祚
     * @since 2023-02-28 0:15
     */
    @LoadBalanced
    @Bean
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }
}
