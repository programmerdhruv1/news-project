package com.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.model.ResponseDataDto;
import com.news.repository.ResponseDataRepository;
import com.news.service.ResponseDataService;

@Service
public class ResponseDataServiceImpl implements ResponseDataService {

	@Autowired
	private ResponseDataRepository repository;
	
	@Override
	public void save(ResponseDataDto dto) {
		repository.save(dto);
	}
	
	@Override
	public List<ResponseDataDto> findAllLimit(String limit) {
		return repository.findAll();
	}
}
