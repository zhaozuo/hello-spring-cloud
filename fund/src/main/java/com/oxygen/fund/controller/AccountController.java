package com.oxygen.fund.controller;

import com.oxygen.common.vo.ResultMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/fund")
public class AccountController {

    /**
     * 扣减账户资金
     *
     * @author 王兆祚
     * @since 2023-02-28 0:09
     */
    @PostMapping("/account/balance/{userId}/{amount}")
    public ResultMessage deductingBalance(
            @PathVariable("userId") Long userId,
            @PathVariable("amount") Double amount,
            HttpServletRequest request) {
        String message = "端口：【" + request.getServerPort() + "】扣减成功";
        return new ResultMessage(true, message);
    }
}
