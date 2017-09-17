package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.service.UserService;

@Controller
// 定义该Controller的根访问路径 /admin
@RequestMapping("/admin")
public class AdminLoginController {
	// 注入UserService
	@Autowired
	private UserService userService;

	// 显示admin首页
	@RequestMapping("/admin")
	public String admin() throws Exception {
		return "admin/admin_login";
	}

	// 登录
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpSession session,
			String username, String password) throws Exception {
		User r = userService.findLoginUser(username, password);
		if (r != null) {
			if (r.getIdent() == 1) {
				session.setAttribute("adminname", r.getUsername());
				session.setAttribute("adminid", r.getId());
				return "redirect:/admin/user/userlist.action";
			} else {
				return "redirect:/admin/error.action";
			}
		} else {
			return "redirect:/admin/error.action";
		}

	}

	// 登录失败页面
	@RequestMapping("/error")
	public ModelAndView error() throws Exception {
		// 创建返回的对象modeAndView
		ModelAndView modelAndView = new ModelAndView();
		// 返回到jsp显示
		modelAndView.setViewName("admin/error");
		return modelAndView;
	}

	// 退出登录
	@RequestMapping("/signout")
	public ModelAndView signout(HttpSession session) throws Exception {
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/admin_login");
		return modelAndView;
	}

}
