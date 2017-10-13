package com.yulu.mangger.dao;

import com.yulu.mangger.bean.News;

import java.util.List;

public interface NewsMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(News record);

	int insertSelective(News record);

	News selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(News record);

	int updateByPrimaryKey(News record);

	List<News> findNewsList(News news);

	List<News> findhotNewsList(News news);

	List<News> findhot7NewsList(News news);

	List<News> findhot30NewsList(News news);

	List<News> findSort2NewsList(News news);

	List<News> findSort7NewsList(News news);

}