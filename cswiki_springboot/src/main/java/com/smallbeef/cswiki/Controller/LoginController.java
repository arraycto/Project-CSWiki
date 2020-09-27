package com.smallbeef.cswiki.Controller;

import com.smallbeef.cswiki.Entity.UserInfo;
import com.smallbeef.cswiki.Json.Result;
import com.smallbeef.cswiki.Json.ResultFactory;
import com.smallbeef.cswiki.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 用户登录
     * @param requestUserInfo
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody UserInfo requestUserInfo) {
        // 获取前端传值
        String username = requestUserInfo.getUsername();
        String password = requestUserInfo.getPassword();
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        // 从数据库中查询用户
        UserInfo userInfo = userInfoService.getByUsernameAndPassword(username, password);

        if (userInfo == null) {
            String message = "账号或密码错误";
            return ResultFactory.buildFailResult(message);
        } else {
            String message = "登录成功";
            return ResultFactory.buildSuccessResult(message, requestUserInfo); // 传回该用户对象给前端

        }
    }
}