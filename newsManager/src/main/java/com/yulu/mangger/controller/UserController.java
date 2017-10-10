package com.yulu.mangger.controller;

import com.alibaba.fastjson.JSONObject;
import com.yulu.mangger.bean.Collects;
import com.yulu.mangger.bean.Comments;
import com.yulu.mangger.bean.User;
import com.yulu.mangger.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

@Controller
// 定义该Controller的根访问路径 /admin
@RequestMapping("/user")
public class UserController {
	// 注入UserService.
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("newsService")
	private NewsService newsService;

	@Autowired
	@Qualifier("sortService")
	private SortService sortService;

	@Autowired
	@Qualifier("commentsService")
	private CommentsService commentsService;

	@Autowired
	@Qualifier("collectsService")
	private CollectsService collectsService;

	// 登录
	@RequestMapping("/userLogin")
	public String userLogin(HttpServletRequest request, HttpSession session,
							String username, String password) throws Exception {
		User r = userService.findLoginUser(username, password);
		if (r != null) {
			if (r.getIdent() == 0) {
				session.setAttribute("username", r.getUsername());
				session.setAttribute("userid", r.getId());
				return "redirect:/news/news_index";
			} else {
				return "redirect:/user/userError";
			}
		} else {
			return "redirect:/user/userError";
		}

	}

	// 登录
	@RequestMapping("/userLogin2")
	public void userLogin(HttpSession session,
						String username, String password,
						HttpServletResponse response) throws Exception{
		User r = userService.findLoginUser(username, password);
		if (r != null) {
			if (r.getIdent() == 0) {
				session.setAttribute("username", r.getUsername());
				session.setAttribute("userid", r.getId());
				response.getWriter().println(JSONObject.toJSONString(r));
			} else {
				response.getWriter().println("error");
			}
		} else {
			response.getWriter().println("error");
		}
	}

	// 登录失败页面
	@RequestMapping("/userError")
	public ModelAndView userError() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/error");
		return modelAndView;
	}

	// 退出登录
	@RequestMapping("/userSignout")
	public String userSignout(HttpSession session) throws Exception {
		session.invalidate();
		return "forward:news/news_index";
	}

	// 注册
	@RequestMapping("/register")
	public String register(HttpServletRequest request, HttpSession session,
						   String username, String password, Integer sex, String email,
						   Integer telephone, Integer status, String nickname, String head_image) throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setIdent(0);
		user.setIsdelete(0);
		user.setStatus(status);
		user.setCreateDate(new Date());
		user.setNickname(nickname);
		user.setHead_image(head_image);
		userService.add_do(user);
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		return "forward:success";
	}

	// 注册成功页面
	@RequestMapping("/success")
	public ModelAndView success() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/success");
		return modelAndView;
	}

	// 个人中心
	@RequestMapping("/user_inf")
	public ModelAndView user_inf(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Integer id = (Integer) session.getAttribute("userid");
		User userinf = userService.findUserById(id);
		modelAndView.addObject("userinf", userinf);
		modelAndView.setViewName("user/user_inf");
		return modelAndView;
	}

	// 修改用户页面
	@RequestMapping("/user_inf_edit")
	public ModelAndView user_inf_edit(Integer id) throws Exception {
		// 创建返回的对象modeAndView
		ModelAndView modelAndView = new ModelAndView();
		// 将参数传入Service层进行处理
		User userinf = userService.findUserById(id);
		// 将处理的结果封装到ModelAndViews
		modelAndView.addObject("userinf", userinf);
		// 返回到jsp显示
		modelAndView.setViewName("user/user_inf_edit");
		return modelAndView;
	}

	// 修改
	@RequestMapping("/user_inf_edit_do")
	public String user_inf_edit_do(HttpServletRequest request, Integer id,
								   String username, String password, Integer sex, String email,
								   Integer telephone) throws Exception {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setIdent(0);
		user.setIsdelete(0);
		userService.edit_do(user);
		return "forward:user_inf.action";
	}

	// 我的收藏
	@RequestMapping("/user_collect")
	public ModelAndView user_collect(HttpServletRequest request, Integer userid)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Collects collects = new Collects();
		collects.setUserid(userid);
		List<Collects> collectslist = collectsService
				.findCollectsList(collects);

		modelAndView.addObject("collectslist", collectslist);
		modelAndView.setViewName("user/user_collect");
		return modelAndView;
	}

	// 我的评论
	@RequestMapping("/user_comment")
	public ModelAndView user_comment(HttpServletRequest request, Integer userid)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Comments comments = new Comments();
		comments.setUserid(userid);
		List<Comments> commentslist = commentsService
				.findCommentsList(comments);

		modelAndView.addObject("commentslist", commentslist);
		modelAndView.setViewName("user/user_comment");
		return modelAndView;
	}

}
