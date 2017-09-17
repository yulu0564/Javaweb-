package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.News;
import com.mapper.NewsMapper;
import com.service.NewsService;

public class NewsServiceImp implements NewsService {
	// 注入User
	@Autowired
	private NewsMapper newsMapper;

	@Override
	public List<News> findNewsList(News news) throws Exception {
		// TODO Auto-generated method stub
		return newsMapper.findNewsList(news);
	}

	@Override
	public List<News> findhotNewsList(News news) throws Exception {
		// TODO Auto-generated method stub
		return newsMapper.findhotNewsList(news);
	}

	@Override
	public List<News> findhot7NewsList(News news) throws Exception {
		// TODO Auto-generated method stub
		return newsMapper.findhot7NewsList(news);
	}

	@Override
	public List<News> findhot30NewsList(News news) throws Exception {
		// TODO Auto-generated method stub
		return newsMapper.findhot30NewsList(news);
	}

	@Override
	public List<News> findSort2NewsList(News news) throws Exception {
		// TODO Auto-generated method stub
		return newsMapper.findSort2NewsList(news);
	}

	@Override
	public List<News> findSort7NewsList(News news) throws Exception {
		// TODO Auto-generated method stub
		return newsMapper.findSort7NewsList(news);
	}

	@Override
	public News findNewsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return newsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void edit_do(News news) throws Exception {
		// TODO Auto-generated method stub
		newsMapper.updateByPrimaryKeySelective(news);
	}

	@Override
	public void delete_do(Integer id) throws Exception {
		// TODO Auto-generated method stub
		newsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add_do(News news) throws Exception {
		// TODO Auto-generated method stub
		newsMapper.insertSelective(news);
	}

}
