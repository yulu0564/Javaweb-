package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.News;
import com.entity.Sort;
import com.service.NewsService;
import com.service.SortService;

@Controller
// 定义该Controller的根访问路径 /news
@RequestMapping("/admin/news")
public class ManagerNewsController {
	// 注入UserService
	@Autowired
	private NewsService newsService;
	@Autowired
	private SortService sortService;

	@RequestMapping("/newslist")
	public ModelAndView newslist(HttpServletRequest request, String serach,
			Integer sort) throws Exception {
		// 创建返回的对象modeAndView
		ModelAndView modelAndView = new ModelAndView();
		// 将参数传入Service层进行处理
		News news = new News();
		news.setTitle(serach);
		news.setSort(sort);
		List<News> newslist = newsService.findNewsList(news);
		List<Sort> sortlist = sortService.findSortList(null);
		modelAndView.addObject("sortlist", sortlist);
		modelAndView.addObject("newslist", newslist);
		// 返回到jsp显示
		modelAndView.setViewName("admin/news/admin_news_list");
		return modelAndView;
	}

	// 显示添加新闻界面
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<Sort> sortlist = sortService.findSortList(null);
		modelAndView.addObject("sortlist", sortlist);
		modelAndView.setViewName("admin/news/admin_news_addAndedit");
		return modelAndView;
	}

	// 添加新闻
	@RequestMapping("/add_do")
	public String add_do(HttpServletRequest request, String title,
			String contect, String fromto, Integer sort, Integer isdelete)
			throws Exception {
		Date date = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowtime = time.format(date);
		News news = new News();
		news.setTitle(title);
		news.setContect(contect);
		news.setFromto(fromto);
		news.setFromuser("admin");
		news.setSort(sort);
		news.setTime(nowtime);
		news.setIsdelete(0);
		newsService.add_do(news);
		return "forward:newslist.action";
	}

	// 修改页面
	@RequestMapping("/edit")
	public ModelAndView edit(Integer id) throws Exception {
		// 创建返回的对象modeAndView
		ModelAndView modelAndView = new ModelAndView();
		// 将参数传入Service层进行处理
		List<Sort> sortlist = sortService.findSortList(null);
		modelAndView.addObject("sortlist", sortlist);
		News newsinf = newsService.findNewsById(id);
		modelAndView.addObject("newsinf", newsinf);
		// 返回到jsp显示
		modelAndView.setViewName("admin/news/admin_news_addAndedit");
		return modelAndView;
	}

	// 修改
	@RequestMapping("/edit_do")
	public String edit_do(HttpServletRequest request, Integer id, String title,
			String contect, String fromto, Integer sort, Integer isdelete)
			throws Exception {
		Date date = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowtime = time.format(date);
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setContect(contect);
		news.setFromto(fromto);
		news.setFromuser("admin");
		news.setSort(sort);
		news.setTime(nowtime);
		news.setIsdelete(0);
		newsService.edit_do(news);
		return "forward:newslist.action";
	}

	// 删除
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Integer id)
			throws Exception {
		newsService.delete_do(id);
		return "forward:newslist.action";
	}
}
