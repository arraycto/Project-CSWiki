package com.smallbeef.cswiki;

import com.smallbeef.cswiki.Dao.UserInfoDao;
import com.smallbeef.cswiki.Entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class CswikiApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserInfoDao userInfoDao;

    @Test
    void contextLoads() {
        System.out.println(userInfoDao.findByUsername("admin"));
    }

}
