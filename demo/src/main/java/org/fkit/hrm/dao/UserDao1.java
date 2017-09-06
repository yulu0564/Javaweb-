package org.fkit.hrm.dao;

import org.fkit.hrm.domain.User;

import java.util.Map;

/**
 * @Description: UserMapper接口
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a>
 * @author 肖文吉	36750064@qq.com
 * @version V1.0
 */
public interface UserDao1  {

	// 根据登录名和密码查询员工
	User selectByLoginnameAndPassword1(
			Map<String,Object> params);

}
