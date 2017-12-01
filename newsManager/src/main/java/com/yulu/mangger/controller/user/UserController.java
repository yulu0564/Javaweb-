package com.yulu.mangger.controller.user;

import com.yulu.mangger.bean.Collects;
import com.yulu.mangger.bean.Comments;
import com.yulu.mangger.bean.User;
import com.yulu.mangger.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @Qualifier("commentsService")
    private CommentsService commentsService;

    @Autowired
    @Qualifier("collectsService")
    private CollectsService collectsService;

    // 登录
    @RequestMapping("/userLoginAndView")
    public String userLogin(HttpServletRequest request, HttpSession session,
                            String username, String password) throws Exception {
        User r = userService.findLoginUser(username, password);
        if (r != null) {
            if (r.getIdent() == 0) {
                session.setAttribute("username", r.getUsername());
                session.setAttribute("nickname", r.getNickname());
                session.setAttribute("userid", r.getId());
                return "redirect:/news/news_index";
            } else {
                return "redirect:/user/userError";
            }
        } else {
            return "redirect:/user/userError";
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
        return "forward:news/news_list";
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
    public ModelAndView user_inf(HttpSession session, HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Integer id = (Integer) session.getAttribute("userid");
        User userinf = userService.findUserById(id);
        modelAndView.addObject("userinf", userinf);
        modelAndView.setViewName("user/user_inf");
        return modelAndView;
    }

    // 修改用户页面
    @RequestMapping("/user_inf_edit")
    public ModelAndView user_inf_edit(HttpSession session, HttpServletRequest request) throws Exception {
        // 创建返回的对象modeAndView
        ModelAndView modelAndView = new ModelAndView();
        Integer id = (Integer) session.getAttribute("userid");
        // 将参数传入Service层进行处理
        User userinf = userService.findUserById(id);
        // 将处理的结果封装到ModelAndViews
        modelAndView.addObject("userinf", userinf);
        // 返回到jsp显示
        modelAndView.setViewName("user/user_inf_edit");
        return modelAndView;
    }

    // 我的收藏
    @RequestMapping("/user_collect")
    public ModelAndView user_collect(HttpSession session, HttpServletRequest request)
            throws Exception {
        Integer userid = (Integer) session.getAttribute("userid");
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
    public ModelAndView user_comment(HttpSession session, @RequestParam(required = false, defaultValue = "1") int page,
                                     @RequestParam(required = false, defaultValue = "10") int rows)
            throws Exception {
        Integer userid = (Integer) session.getAttribute("userid");
        ModelAndView modelAndView = new ModelAndView();
        Comments comments = new Comments();
        comments.setUserid(userid);
        List<Comments> commentslist = commentsService
                .findCommentsList(comments, page, rows);

        modelAndView.addObject("commentslist", commentslist);
        modelAndView.setViewName("user/user_comment");
        return modelAndView;
    }
}
