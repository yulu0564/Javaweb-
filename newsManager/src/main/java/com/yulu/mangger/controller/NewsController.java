package com.yulu.mangger.controller;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	@RequestMapping("/news_index")
	public ModelAndView newslist(HttpServletRequest request, String serach)
			throws Exception {
		// 创建返回的对象modeAndView
		ModelAndView modelAndView = new ModelAndView();
		// 将参数传入Service层进行处理
		News news = new News();
		news.setTitle(serach);
		List<News> newslist = newsService.findNewsList(news);
		List<Sort> sortlist = sortService.findSortList(null);
		// 最新
		List<News> hotNews = newsService.findhotNewsList(null);
		// 7天热门
		List<News> hotNews7 = newsService.findhot7NewsList(null);
		// 30天热门
		List<News> hotNews30 = newsService.findhot30NewsList(null);
		// 影视娱乐
		List<News> sort2 = newsService.findSort2NewsList(null);
		// 国际社会
		List<News> sort7 = newsService.findSort7NewsList(null);

		modelAndView.addObject("sort2", sort2);
		modelAndView.addObject("sort7", sort7);
		modelAndView.addObject("hotNews", hotNews);
		modelAndView.addObject("hotNews7", hotNews7);
		modelAndView.addObject("hotNews30", hotNews30);
		modelAndView.addObject("sortlist", sortlist);
		modelAndView.addObject("newslist", newslist);
		// 返回到jsp显示
		modelAndView.setViewName("news/news_index");
		return modelAndView;
	}

	@RequestMapping("/news_list")
	public ModelAndView news_list(HttpServletRequest request, Integer type)
			throws Exception {
		// 创建返回的对象modeAndView
		ModelAndView modelAndView = new ModelAndView();
		// 将参数传入Service层进行处理
		News news = new News();
		if(type!=null&&type!=0) {
			news.setSort(type);
		}
		List<News> newslist = newsService.findNewsList(news);
		List<Sort> sortlist = sortService.findSortList(null);
		modelAndView.addObject("sortlist", sortlist);
		modelAndView.addObject("newslist", newslist);
		// 返回到jsp显示
		modelAndView.setViewName("news/news_list");
		return modelAndView;
	}

	@RequestMapping("/news_inf/{detail}")
	public ModelAndView news_inf(HttpSession session,@PathVariable Integer detail)
			throws Exception {
		// 创建返回的对象modeAndView
		ModelAndView modelAndView = new ModelAndView();
		// 将参数传入Service层进行处理
		News newsinf = newsService.findNewsById(detail);
		List<Sort> sortlist = sortService.findSortList(null);

		Comments comments = new Comments();
		comments.setNewsid(detail);
		List<Comments> commentslist = commentsService
				.findCommentsList(comments);

		modelAndView.addObject("commentslist", commentslist);
		modelAndView.addObject("sortlist", sortlist);
		modelAndView.addObject("newsinf", newsinf);
		Integer userid = (Integer) session.getAttribute("userid");
		if(userid!=null) {
			Collects collects = collectsService.findCollects(detail, userid);
			modelAndView.addObject("collects", collects);
		}
		// 返回到jsp显示
		modelAndView.setViewName("news/news_inf");
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
				.findCommentsList(comments);

		modelAndView.addObject("commentslist", commentslist);
		modelAndView.addObject("sortlist", sortlist);
		modelAndView.addObject("newsinf", newsinf);
		// 返回到jsp显示
		modelAndView.setViewName("news/news_details");
		return modelAndView;
	}

}
