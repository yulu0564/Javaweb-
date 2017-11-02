package com.yulu.mangger.service;

import com.yulu.mangger.bean.Comments;

import java.util.List;

public interface CommentsService {
	public List<Comments> findCommentsList(Comments comments,int pageNum, int pageSize) throws Exception;
	public Comments findCommentsId(int id) throws Exception;
	public void delete_do(Integer id) throws Exception;

	public int add_do(Comments comments) throws Exception;

}
