package com.yulu.mangger.controller.news;

import com.github.pagehelper.PageInfo;
import com.yulu.util.DataUtils;
import com.yulu.mangger.bean.*;
import com.yulu.mangger.service.CollectsService;
import com.yulu.mangger.service.CommentsService;
import com.yulu.mangger.service.NewsService;
import com.yulu.mangger.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
// 定义该Controller的根访问路径 /news
@RequestMapping("/news")
public class NewsController {
    // 注入UserService.
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

    /**
     * 首页
     */
    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, Integer type, @RequestParam(required = false, defaultValue = "1") int page,
                              @RequestParam(required = false, defaultValue = "10") int rows)
            throws Exception {
        // 创建返回的对象modeAndView
        ModelAndView modelAndView = new ModelAndView();
        // 将参数传入Service层进行处理
        News news = new News();
        if (type != null && type != 0) {
            news.setSort(type);
        }
        List<News> newslist = newsService.findNewsList(news, page, rows);
        List<Sort> sortlist = sortService.findSortList(null);
        PageInfo<News> p = new PageInfo<>(newslist);
        modelAndView.addObject("total", p.getTotal());
        modelAndView.addObject("sortlist", sortlist);
        modelAndView.addObject("newslist", newslist);
        // 返回到jsp显示
        modelAndView.setViewName("news/news_list1");
        return modelAndView;
    }

    /**
     * 新闻列表
     */
    @RequestMapping("list/{type}")
    public ModelAndView news_list(HttpServletRequest request, Integer type, @RequestParam(required = false, defaultValue = "1") int page,
                                  @RequestParam(required = false, defaultValue = "10") int rows)
            throws Exception {
        // 创建返回的对象modeAndView
        ModelAndView modelAndView = new ModelAndView();
        // 将参数传入Service层进行处理
        News news = new News();
        if (type != null && type != 0) {
            news.setSort(type);
        }
        List<News> newslist = newsService.findNewsList(news, page, rows);
        List<Sort> sortlist = sortService.findSortList(null);
        PageInfo<News> p = new PageInfo<>(newslist);
        modelAndView.addObject("total", p.getTotal());
        modelAndView.addObject("sortlist", sortlist);
        modelAndView.addObject("newslist", newslist);
        // 返回到jsp显示
        modelAndView.setViewName("news/news_list");
        return modelAndView;
    }

    @RequestMapping("/search_list")
    public ModelAndView newslist(HttpServletRequest request, String serach,
                                 String sort, @RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false, defaultValue = "10") int rows) throws Exception {
        // 创建返回的对象modeAndView
        ModelAndView modelAndView = new ModelAndView();
        // 将参数传入Service层进行处理
        News news = new News();
        news.setTitle(serach);
        if (sort != null) {
            news.setSort(DataUtils.parseInt(sort));
        }
        List<News> newslist = newsService.findNewsList(news, page, rows);
        List<Sort> sortlist = sortService.findSortList(null);
        modelAndView.addObject("sortlist", sortlist);
        modelAndView.addObject("newslist", newslist);
        // 返回到jsp显示
        modelAndView.setViewName("/news/search_list");
        return modelAndView;
    }

    @RequestMapping("/news_inf/{detail}")
    public ModelAndView news_inf(HttpSession session, @PathVariable Integer detail)
            throws Exception {
        // 创建返回的对象modeAndView
        ModelAndView modelAndView = new ModelAndView();
        // 将参数传入Service层进行处理
        News newsinf = newsService.findNewsById(detail);
        List<Sort> sortlist = sortService.findSortList(null);

        Comments comments = new Comments();
        comments.setNewsid(detail);
        List<Comments> commentslist = commentsService
                .findCommentsList(comments, 1, 2);
        PageInfo<Comments> p = new PageInfo<Comments>(commentslist);
        modelAndView.addObject("commentslist", commentslist);
        modelAndView.addObject("sortlist", sortlist);
        modelAndView.addObject("newsinf", newsinf);
        modelAndView.addObject("total", p.getTotal());
        Integer userid = (Integer) session.getAttribute("userid");
        if (userid != null) {
            Collects mCollects = new Collects();
            mCollects.setNewsid(detail);
            mCollects.setUserid(userid);
            Collects collects = collectsService.findCollects(mCollects);
            modelAndView.addObject("collects", collects);
        }
        // 返回到jsp显示
        modelAndView.setViewName("news/news_content1");
        return modelAndView;
    }

    @RequestMapping("/news_details/{detail}")
    public ModelAndView news_details(@PathVariable Integer detail)
            throws Exception {
        // 创建返回的对象modeAndView
        ModelAndView modelAndView = new ModelAndView();
        // 将参数传入Service层进行处理
        News newsinf = newsService.findNewsById(detail);
        List<Sort> sortlist = sortService.findSortList(null);
        Comments comments = new Comments();
        comments.setNewsid(detail);
        List<Comments> commentslist = commentsService
                .findCommentsList(comments, 1, 2);

        modelAndView.addObject("commentslist", commentslist);
        modelAndView.addObject("sortlist", sortlist);
        modelAndView.addObject("newsinf", newsinf);
        // 返回到jsp显示
        modelAndView.setViewName("news/news_details");
        return modelAndView;
    }

}
