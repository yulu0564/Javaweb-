package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Comments;
import com.mapper.CommentsMapper;
import com.service.CommentsService;

public class CommentsServiceImp implements CommentsService {
	// 注入Mapper
	@Autowired
	private CommentsMapper commentsMapper;

	@Override
	public List<Comments> findCommentsList(Comments comments) throws Exception {
		// TODO Auto-generated method stub
		return commentsMapper.findCommentsList(comments);
	}


	@Override
	public void delete_do(Integer id) throws Exception {
		// TODO Auto-generated method stub
		commentsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add_do(Comments comments) throws Exception {
		// TODO Auto-generated method stub
		commentsMapper.insertSelective(comments);
	}

	

}
