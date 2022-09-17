package com.news.service;

import java.util.List;

import com.news.model.ResponseDataDto;

public interface ResponseDataService {
	
	public void save(ResponseDataDto dto);
	
	List<ResponseDataDto> findAllLimit(String limit);

}
