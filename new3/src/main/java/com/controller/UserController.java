package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Collects;
import com.entity.Comments;
import com.entity.User;
import com.service.CollectsService;
import com.service.CommentsService;
import com.service.NewsService;
import com.service.SortService;
import com.service.UserService;

@Controller
// 定义该Controller的根访问路径 /admin
@RequestMapping("/news")
public class UserController {
	// 注入UserService.
	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private SortService sortService;
	@Autowired
	private CommentsService commentsService;
	@Autowired
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
				return "redirect:/news/news_index.action";
			} else {
				return "redirect:/news/userError.action";
			}
		} else {
			return "redirect:/news/userError.action";
		}

	}

	// 登录失败页面
	@RequestMapping("/userError")
	public ModelAndView userError() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("news/error");
		return modelAndView;
	}

	// 退出登录
	@RequestMapping("/userSignout")
	public String userSignout(HttpSession session) throws Exception {
		session.invalidate();
		return "forward:news_index.action";
	}

	// 注册
	@RequestMapping("/register")
	public String register(HttpServletRequest request, HttpSession session,
			String username, String password, Integer sex, String email,
			Integer telephone) throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setIdent(0);
		user.setIsdelete(0);
		userService.add_do(user);
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		return "forward:success.action";
	}

	// 注册成功页面
	@RequestMapping("/success")
	public ModelAndView success() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("news/success");
		return modelAndView;
	}

	// 个人中心
	@RequestMapping("/user_inf")
	public ModelAndView user_inf(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Integer id = (Integer) session.getAttribute("userid");
		User userinf = userService.findUserById(id);
		modelAndView.addObject("userinf", userinf);
		modelAndView.setViewName("news/user_inf");
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
		modelAndView.setViewName("news/user_inf_edit");
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
		modelAndView.setViewName("news/user_collect");
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
		modelAndView.setViewName("news/user_comment");
		return modelAndView;
	}

}
