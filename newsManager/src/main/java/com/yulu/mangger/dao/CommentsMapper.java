package com.yulu.mangger.dao;

import com.yulu.mangger.bean.Comments;
import com.yulu.mangger.bean.CommentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentsMapper {
	int countByExample(CommentsExample example);

	int deleteByExample(CommentsExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Comments record);

	int insertSelective(Comments record);

	List<Comments> selectByExample(CommentsExample example);

	Comments selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Comments record,
                                 @Param("example") CommentsExample example);

	int updateByExample(@Param("record") Comments record,
                        @Param("example") CommentsExample example);

	int updateByPrimaryKeySelective(Comments record);

	int updateByPrimaryKey(Comments record);

	List<Comments> findCommentsList(Comments comments);
	Comments findCommentsId(Integer id);
}