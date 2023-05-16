package com.oxygen.fund.controller;


import com.oxygen.common.pojo.UserInfo;
import com.oxygen.common.vo.ResultMessage;
import com.oxygen.fund.facade.UserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    private UserFacade userFacade = null;

    @GetMapping("/user/{id}")
    public UserInfo getUser(@PathVariable("id") Long id) {
        return userFacade.getUser(id);
    }

    @GetMapping("/user/{id}/{userName}/{note}")
    public UserInfo updateUser(@PathVariable("id") Long id,
                               @PathVariable("userName") String userName,
                               @PathVariable("note") String note) {
        UserInfo user = new UserInfo(id, userName, note);
        return userFacade.putUser(user);
    }

    @GetMapping("/users/{ids}")
    public ResponseEntity<List<UserInfo>> findUsers2(@PathVariable("ids") Long []ids) {
        return userFacade.findUsers2(ids);
    }

    @GetMapping("/user/delete/{id}")
    public ResultMessage deleteUser(@PathVariable("id") Long id) {
        return userFacade.deleteUser(id);
    }

    @GetMapping("/user/file/page")
    public ModelAndView filePage() {
        return new ModelAndView("file");
    }

    @PostMapping("/user/file/upload")
    public ResultMessage uploadFile(@RequestPart("file") MultipartFile file) {
        return userFacade.uploadFile(file);
    }
}