package com.smallbeef.cswiki.Service;

import com.smallbeef.cswiki.Dao.UserInfoDao;
import com.smallbeef.cswiki.Entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    // 根据 username 查询
    public UserInfo getByUsername(String username){
        return userInfoDao.findByUsername(username);
    }

    // 根据 username 和 password 查询
    public UserInfo getByUsernameAndPassword(String username, String password){
        return userInfoDao.findByUsernameAndPassword(username, password);
    }

    // 添加用户
    public void addUser(UserInfo userInfo){
        userInfoDao.save(userInfo);
    }

    // 判断用户名是否存在
    public boolean isExistUsername(String username){
        UserInfo userInfo = getByUsername(username);
        if(userInfo == null)
            return false; // 用户名不存在
        else
            return true; // 用户已经存在
    }

}
