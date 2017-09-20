package com.yulu.mangger.dao;

import com.yulu.mangger.bean.News;
import com.yulu.mangger.bean.NewsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
	int countByExample(NewsExample example);

	int deleteByExample(NewsExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(News record);

	int insertSelective(News record);

	List<News> selectByExample(NewsExample example);

	News selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") News record,
                                 @Param("example") NewsExample example);

	int updateByExample(@Param("record") News record,
                        @Param("example") NewsExample example);

	int updateByPrimaryKeySelective(News record);

	int updateByPrimaryKey(News record);

	List<News> findNewsList(News news);

	List<News> findhotNewsList(News news);

	List<News> findhot7NewsList(News news);

	List<News> findhot30NewsList(News news);

	List<News> findSort2NewsList(News news);

	List<News> findSort7NewsList(News news);

}