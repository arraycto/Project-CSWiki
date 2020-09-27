package com.smallbeef.cswiki.Dao;

import com.smallbeef.cswiki.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {

    // 通过 username 查询
    UserInfo findByUsername(String username);

    // 通过 username 和 password 查询
    UserInfo findByUsernameAndPassword(String username, String password);
}
