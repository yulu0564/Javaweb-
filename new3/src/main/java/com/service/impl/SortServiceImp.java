package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Sort;
import com.mapper.SortMapper;
import com.service.SortService;

public class SortServiceImp implements SortService {
	// 注入User
	@Autowired
	private SortMapper sortmapper;

	@Override
	public List<Sort> findSortList(Sort sort) throws Exception {
		// TODO Auto-generated method stub
		return sortmapper.findSortList(sort);
	}

	@Override
	public Sort findSortById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return sortmapper.selectByPrimaryKey(id);
	}

	@Override
	public void edit_do(Sort sort) throws Exception {
		// TODO Auto-generated method stub
		sortmapper.updateByPrimaryKeySelective(sort);
	}

	@Override
	public void delete_do(Integer id) throws Exception {
		// TODO Auto-generated method stub
		sortmapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add_do(Sort sort) throws Exception {
		// TODO Auto-generated method stub
		sortmapper.insertSelective(sort);
	}

	@Override
	public void ban_do(Integer id) throws Exception {
		Sort sort = new Sort();
		sort.setId(id);
		sort.setIsdelete(1);
		sortmapper.banById(sort);
	}

	@Override
	public void ok_do(Integer id) throws Exception {
		Sort sort = new Sort();
		sort.setId(id);
		sort.setIsdelete(0);
		sortmapper.okById(sort);
	}
}
