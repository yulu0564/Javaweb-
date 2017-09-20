package com.yulu.mangger.service.impl;

import com.yulu.mangger.bean.User;
import com.yulu.mangger.dao.UserDao;
import com.yulu.mangger.service.UserService;
import com.yulu.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 服务层接口实现类
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("userService")
public class UserServiceImp implements UserService {

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


    /**
     * HrmServiceImpl接口findUser方法实现
     * @see { HrmService }
     * */
    @Transactional(readOnly=true)
    @Override
    public List<User> findUser(User user, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        params.put("user", user);
        int recordCount = userDao.count(params);
        pageModel.setRecordCount(recordCount);
        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }
        List<User> users = userDao.selectByPage(params);

        return users;
    }

    /**
     * HrmServiceImpl接口findUserById方法实现
     * @see { HrmService }
     * */
    @Transactional(readOnly=true)
    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    /**
     * HrmServiceImpl接口removeUserById方法实现
     * @see { HrmService }
     * */
    @Override
    public void removeUserById(Integer id) {
        userDao.deleteById(id);

    }

    /**
     * HrmServiceImpl接口addUser方法实现
     * @see { HrmService }
     * */
    @Override
    public void modifyUser(User user) {
        userDao.update(user);

    }

    /**
     * HrmServiceImpl接口modifyUser方法实现
     * @see { HrmService }
     * */
    @Override
    public void addUser(User user) {
        userDao.save(user);

    }
}
