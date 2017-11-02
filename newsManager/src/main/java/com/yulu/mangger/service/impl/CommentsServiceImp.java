package com.yulu.mangger.service.impl;

import com.github.pagehelper.PageHelper;
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
	public List<Comments> findCommentsList(Comments comments,int pageNum, int rows) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, rows);
		return commentsMapper.findCommentsList(comments);
	}

	@Override
	public Comments findCommentsId(int id) throws Exception {
		return commentsMapper.findCommentsId(id);
	}


	@Override
	public void delete_do(Integer id) throws Exception {
		// TODO Auto-generated method stub
		commentsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int add_do(Comments comments) throws Exception {
		// TODO Auto-generated method stub
		return  commentsMapper.insertSelective(comments);
	}

	

}
