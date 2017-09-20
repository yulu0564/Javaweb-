package com.yulu.mangger.service.impl;

import com.yulu.mangger.bean.Comments;
import com.yulu.mangger.dao.CommentsMapper;
import com.yulu.mangger.service.CommentsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("commentsService")
public class CommentsServiceImp implements CommentsService {
	// 注入Mapper
	@Resource
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
