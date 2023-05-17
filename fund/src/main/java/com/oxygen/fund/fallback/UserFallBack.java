package com.oxygen.fund.fallback;

import com.oxygen.common.pojo.UserInfo;
import com.oxygen.common.vo.ResultMessage;
import com.oxygen.fund.facade.UserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 要使类提供降级方法，需要满足3个条件
 * 1.实现openFeign接口定义的方法
 * 2.将Bean注册为Spring Bean
 * 3.使用@FeignClient的fallback配置项指向当前类
 * @author 王兆祚
 * @since 2023-05-17 22:50
 */
@Component
public class UserFallBack implements UserFacade {
    /**
     * 获取用户信息
     *
     * @param id -- 用户编号
     * @return 用户信息
     */
    @Override
    public UserInfo getUser(Long id) {
        return new UserInfo(null, null, null);
    }

    /**
     * 修改用户信息
     *
     * @param userInfo -- 用户
     * @return 用户信息
     */
    @Override
    public UserInfo putUser(UserInfo userInfo) {
        return new UserInfo(null, null, null);
    }

    /**
     * 根据id数组获取用户列表
     *
     * @param ids -- 数组
     * @return 用户列表
     */
    @Override
    public ResponseEntity<List<UserInfo>> findUsers2(@RequestParam("ids") Long[] ids) {
        return null;
    }

    /**
     * 删除用户信息，使用请求头传参
     *
     * @param id -- 用户编号
     * @return 成败结果
     */
    @Override
    public ResultMessage deleteUser(Long id) {
        return new ResultMessage(false, "降级服务");
    }

    /**
     * 传递文件流
     *
     * @param file -- 文件流
     * @return 成败结果
     */
    @Override
    public ResultMessage uploadFile(MultipartFile file) {
        return new ResultMessage(false, "降级服务");
    }
}
