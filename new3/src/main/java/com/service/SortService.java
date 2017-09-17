package com.service;

import java.util.List;

import com.entity.Sort;

public interface SortService {
	public List<Sort> findSortList(Sort sort) throws Exception;

	public Sort findSortById(Integer id) throws Exception;

	public void edit_do(Sort sort) throws Exception;

	public void delete_do(Integer id) throws Exception;

	public void add_do(Sort sort) throws Exception;

	public void ban_do(Integer id) throws Exception;

	public void ok_do(Integer id) throws Exception;
}
