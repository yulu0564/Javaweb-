package com.yulu.mangger.dao;


import com.yulu.mangger.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import static com.yulu.util.common.HrmConstants.USERTABLE;

/**   
 * @Description: UserMapper接口
 */
public interface UserDao {

	// 根据登录名和密码查询员工
	@Select("select * from "+USERTABLE+" where loginname = #{loginname} and password = #{password}")
	User selectByLoginnameAndPassword(
            @Param("loginname") String loginname,
            @Param("password") String password);
	
	// 根据id查询用户
	@Select("select * from "+USERTABLE+" where ID = #{id}")
	User selectById(Integer id);
	
	// 根据id删除用户
	@Delete(" delete from "+USERTABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
}