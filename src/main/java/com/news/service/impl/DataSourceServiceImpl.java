package com.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.model.DataSourceDto;
import com.news.repository.DataSourceRepository;
import com.news.service.DataSourceService;

@Service
public class DataSourceServiceImpl implements DataSourceService {

	@Autowired
	private DataSourceRepository repository;

	@Override
	public void save(DataSourceDto dto) {
		repository.save(dto);
	}
}
