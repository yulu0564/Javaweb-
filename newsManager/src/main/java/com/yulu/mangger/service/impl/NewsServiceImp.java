package com.yulu.mangger.service.impl;

import com.github.pagehelper.PageHelper;
import com.yulu.mangger.bean.News;
import com.yulu.mangger.dao.NewsMapper;
import com.yulu.mangger.service.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("newsService")
public class NewsServiceImp implements NewsService {
	// 注入User
	@Resource
	private NewsMapper newsMapper;

	@Override
	public List<News> findNewsList(News news, int pageNum, int pageSize) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return newsMapper.findNewsList(news);
	}

	@Override
	public List<News> findhotNewsList(News news) throws Exception {
		return newsMapper.findhotNewsList(news);
	}

	@Override
	public List<News> findhot7NewsList(News news) throws Exception {
		return newsMapper.findhot7NewsList(news);
	}

	@Override
	public List<News> findhot30NewsList(News news) throws Exception {
		return newsMapper.findhot30NewsList(news);
	}

	@Override
	public List<News> findSort2NewsList(News news) throws Exception {
		return newsMapper.findSort2NewsList(news);
	}

	@Override
	public List<News> findSort7NewsList(News news) throws Exception {
		return newsMapper.findSort7NewsList(news);
	}

	@Override
	public News findNewsById(Integer id) throws Exception {
		return newsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void edit_do(News news) throws Exception {
		newsMapper.updateByPrimaryKeySelective(news);
	}

	@Override
	public void delete_do(Integer id) throws Exception {
		newsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add_do(News news) throws Exception {
		newsMapper.insertSelective(news);
	}

}
