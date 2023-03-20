package com.oxygen.product.config;

import com.netflix.discovery.endpoint.EndpointUtils;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;
import com.oxygen.config.FundConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon全局配置类（优先级1）
 *
 * @author 王兆祚
 * @since 2023-03-01 22:37
 */
@Configuration
// 配置单个微服务（优先级3）
// @RibbonClient(name = "fund", configuration = FundConfiguration.class)
// @RibbonClients(value = {
//         @RibbonClient(name = "FUND", configuration = FundConfiguration.class),
//         @RibbonClient(name = "USER", configuration = FundConfiguration.class),
// }, defaultConfiguration = FundConfiguration.class)
public class GlobalConfiguration {
    /**
     * 服务过滤器
     *
     * @author 王兆祚
     * @since 2023-03-01 22:25
     */
    @Bean(name = "ribbonServerListFilter")
    public ServerListFilter<Server> serverServerListFilter() {
        // 使用优先选择的过滤器
        ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
        // 使用默认Zone
        filter.setZone(EndpointUtils.DEFAULT_ZONE);
        return filter;
    }

    /**
     * 负载均衡策略
     *
     * @author 王兆祚
     * @since 2023-03-01 22:27
     */
    @Bean
    public IRule rule() {
        // 使用随机选择服务的策略
        return new RandomRule();
    }
}
