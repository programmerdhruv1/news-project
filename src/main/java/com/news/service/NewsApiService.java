package com.news.service;

import java.util.Date;

import com.news.response.NewsResponse;

public interface NewsApiService {

	public NewsResponse everything(String q, Date from, Date to, String sortBy);
	
}
