//package org.fkit.hrm.dao;
//
//
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.fkit.hrm.domain.User;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//
///**
// * @Description: UserMapper接口
// * <br>网站：<a href="http://www.fkit.org">疯狂Java</a>
// * @author 肖文吉	36750064@qq.com
// * @version V1.0
// */
//@Repository("userDao222")
//public class UserDao1Impl  extends SqlSessionDaoSupport implements UserDao1{
//    @Resource
//    public void setSuperSessionFactory(SqlSessionFactory sessionFactory){
//        this.setSqlSessionFactory(sessionFactory);
//    }
//
//	// 根据登录名和密码查询员工
////	@Select("select * from "+USERTABLE+" where loginname = #{loginname} and password = #{password}")
//	@Override
//	public User selectByLoginnameAndPassword1(
//            String loginname,
//            String password){
//		HashMap<String, Object> params = new HashMap<String, Object>();
//		// 设置loginname和password属性
//		params.put("loginname", loginname);
//		params.put("password", password);
//		User users = this.getSqlSession().selectOne("getUser",params);
//		return users;
//	}
//
//}
