package com.news.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.model.DataSourceDto;
import com.news.model.ResponseDataDto;
import com.news.response.NewsResponse;
import com.news.response.ResponseData;
import com.news.service.DataSourceService;
import com.news.service.NewsApiService;
import com.news.service.ResponseDataService;
import com.news.utils.Utils;

@RestController
@RequestMapping("/sync")
public class NewsRestController {
	
	@Autowired
	private NewsApiService newsApiService;
	
	@Autowired
	private ResponseDataService responseDataService;
	
	@Autowired
	private DataSourceService dataSourceService;
	

	@RequestMapping("/addArtical")
	public ResponseEntity<?> addArtical(){
		NewsResponse response = newsApiService.everything("google", null, null, "");
		
		if(response.getStatus().equals("ok")) {
			for(int i=0; i<10; i++) {
				ResponseData data = response.getArticles().get(i);
				
				DataSourceDto dataSource = new DataSourceDto();
				dataSource.setName(data.getSource().getName());
				dataSource.setSourceId(data.getSource().getId());
				dataSourceService.save(dataSource);
				
				ResponseDataDto responseData = new ResponseDataDto();
				responseData.setSource(dataSource);
				responseData.setAuthor(data.getAuthor());
				responseData.setTitle(data.getTitle());
				responseData.setDescription(data.getDescription());
				responseData.setUrl(data.getUrl());
				responseData.setUrlToImage(data.getUrlToImage());
				responseData.setPublishedAt(data.getPublishedAt());
				responseData.setContent(data.getContent());
				responseDataService.save(responseData);
			}
		}
		return new ResponseEntity<>(newsApiService.everything("google", null, null, "").toString(),HttpStatus.OK);
	}
	
}
