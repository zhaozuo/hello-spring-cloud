package com.oxygen.product.controller;

import com.oxygen.common.vo.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private RestTemplate restTemplate = null;

    @GetMapping("/purchase/{userId}/{productId}/{amount}")
    public ResultMessage purchaseProduct(
            @PathVariable("userId") Long userId,
            @PathVariable("productId") Long productId,
            @PathVariable("amount") Double amount) {
        System.out.println("扣减产品余额");
        String url = "http://fund/fund/account/balance/{userId}/{amount}";
        HashMap<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("amount", amount);
        ResultMessage rm = restTemplate.postForObject(url, null, ResultMessage.class, params);
        System.out.println(rm.getMessage());
        System.out.println("记录交易信息");
        return new ResultMessage(true, "交易成功");
    }
}
