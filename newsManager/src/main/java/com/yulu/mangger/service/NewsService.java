package com.yulu.mangger.service;


import com.yulu.mangger.bean.News;

import java.util.List;

public interface NewsService {
	public List<News> findNewsList(News news,int pageNum, int pageSize) throws Exception;

	public List<News> findhotNewsList(News news) throws Exception;

	public List<News> findhot7NewsList(News news) throws Exception;

	public List<News> findhot30NewsList(News news) throws Exception;

	public List<News> findSort2NewsList(News news) throws Exception;

	public List<News> findSort7NewsList(News news) throws Exception;

	public News findNewsById(Integer id) throws Exception;

	public void edit_do(News news) throws Exception;

	public void delete_do(Integer id) throws Exception;

	public void add_do(News news) throws Exception;

}
