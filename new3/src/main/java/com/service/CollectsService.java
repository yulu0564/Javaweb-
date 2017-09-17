package com.service;

import java.util.List;

import com.entity.Collects;

public interface CollectsService {
	public List<Collects> findCollectsList(Collects collects) throws Exception;

	public void delete_do(Integer id) throws Exception;

	public void add_do(Collects collects) throws Exception;

}
