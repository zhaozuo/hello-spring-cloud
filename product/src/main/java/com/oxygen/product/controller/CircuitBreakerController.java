package com.oxygen.product.controller;

import com.oxygen.common.vo.ResultMessage;
import com.oxygen.product.facade.UserFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CircuitBreakerController {
    @Resource
    private UserFacade userFacade = null;

    @GetMapping("/cr/timeout")
    public ResultMessage timeout() {
        return userFacade.timeout();
    }

    @GetMapping("/cr/exp/{msg}")
    public ResultMessage exp(@PathVariable("msg") String msg) {
        return userFacade.exp(msg);
    }
}
