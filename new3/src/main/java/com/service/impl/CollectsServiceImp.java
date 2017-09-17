package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Collects;
import com.mapper.CollectsMapper;
import com.service.CollectsService;

public class CollectsServiceImp implements CollectsService {
	// 注入Mapper
	@Autowired
	private CollectsMapper collectsMapper;

	@Override
	public List<Collects> findCollectsList(Collects collects) throws Exception {
		// TODO Auto-generated method stub
		return collectsMapper.findCollectsList(collects);
	}

	@Override
	public void delete_do(Integer id) throws Exception {
		// TODO Auto-generated method stub
		collectsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add_do(Collects collects) throws Exception {
		// TODO Auto-generated method stub
		collectsMapper.insertSelective(collects);
	}

}
