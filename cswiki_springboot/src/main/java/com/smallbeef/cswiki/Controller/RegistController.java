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

@RestController
public class RegistController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 用户注册
     * @param requestUserInfo
     * @return
     */
    @CrossOrigin
    @PostMapping("api/regist")
    public Result regist(@RequestBody UserInfo requestUserInfo){
        String username = requestUserInfo.getUsername();

        // 判断该用户名是否已经存在
        if(userInfoService.isExistUsername(username)){
            return ResultFactory.buildFailResult("该用户名已存在");
        }
        else{
            userInfoService.addUser(requestUserInfo);
            return ResultFactory.buildSuccessResult("注册成功", requestUserInfo);
        }
    }

}
