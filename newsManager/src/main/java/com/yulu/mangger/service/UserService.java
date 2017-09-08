package com.yulu.mangger.service;

import com.yulu.mangger.bean.User;
import com.yulu.util.tag.PageModel;

import java.util.List;

/**
 * @Description: 服务层接口
 */
public interface UserService {


    /**
     * 用户登录
     *
     * @param loginname
     * @param password
     * @return User对象
     */
    User login(String loginname, String password);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return 用户对象
     */
    User findUserById(Integer id);

    /**
     * 获得所有用户
     *
     * @return User对象的List集合
     */
    List<User> findUser(User user, PageModel pageModel);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    void removeUserById(Integer id);

    /**
     * 修改用户
     */
    void modifyUser(User user);

    /**
     * 添加用户
     */
    void addUser(User user);
}
