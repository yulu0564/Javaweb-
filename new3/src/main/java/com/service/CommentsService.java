package com.service;

import java.util.List;

import com.entity.Comments;

public interface CommentsService {
	public List<Comments> findCommentsList(Comments comments) throws Exception;

	public void delete_do(Integer id) throws Exception;

	public void add_do(Comments comments) throws Exception;

}
