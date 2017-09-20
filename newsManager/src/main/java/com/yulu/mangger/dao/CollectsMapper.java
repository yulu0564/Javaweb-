package com.yulu.mangger.dao;

import com.yulu.mangger.bean.Collects;
import com.yulu.mangger.bean.CollectsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectsMapper {
	int countByExample(CollectsExample example);

	int deleteByExample(CollectsExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Collects record);

	int insertSelective(Collects record);

	List<Collects> selectByExample(CollectsExample example);

	Collects selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Collects record,
                                 @Param("example") CollectsExample example);

	int updateByExample(@Param("record") Collects record,
                        @Param("example") CollectsExample example);

	int updateByPrimaryKeySelective(Collects record);

	int updateByPrimaryKey(Collects record);

	List<Collects> findCollectsList(Collects collects);
}