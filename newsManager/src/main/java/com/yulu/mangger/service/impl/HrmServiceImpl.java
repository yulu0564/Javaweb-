package com.yulu.mangger.service.impl;

import com.yulu.mangger.bean.User;
import com.yulu.mangger.dao.UserDao;
import com.yulu.mangger.service.HrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 服务层接口实现类
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService {

    /**
     * 自动注入持久层Dao对象
     */
    @Autowired
    private UserDao userDao;

    /*****************用户服务接口实现*************************************/
    /**
     * HrmServiceImpl接口login方法实现
     *
     * @see { HrmService }
     */
    @Transactional(readOnly = true)
    @Override
    public User login(String loginname, String password) {
//		System.out.println("HrmServiceImpl login -- >>");
        return userDao.selectByLoginnameAndPassword(loginname, password);
    }


}
