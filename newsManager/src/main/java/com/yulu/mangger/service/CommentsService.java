package com.yulu.mangger.service;

import com.yulu.mangger.bean.Comments;

import java.util.List;

public interface CommentsService {
	public List<Comments> findCommentsList(Comments comments) throws Exception;

	public void delete_do(Integer id) throws Exception;

	public void add_do(Comments comments) throws Exception;

}
