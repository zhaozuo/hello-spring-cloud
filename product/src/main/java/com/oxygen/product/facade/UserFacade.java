package com.oxygen.product.facade;

import com.oxygen.common.vo.ResultMessage;

public interface UserFacade {
    ResultMessage timeout();
    ResultMessage exp(String msg);
}
