package com.news.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.news.response.NewsResponse;
import com.news.response.ResponseData;
import com.news.service.NewsApiService;
import com.news.utils.Utils;

@Service
public class NewsApiServicImpl implements NewsApiService {

	private static final String USER_AGENT = "Mozilla/5.0";
	
	private final String apiKey = "01caa68726cb409797b1fc212558e65e";
	
	private final String apiUrl = "https://newsapi.org/v2";
	
	@Override
	public NewsResponse everything(String q, Date from, Date to, String sortBy) {
		System.out.println("fromDate: "+from != null ? Utils.dateToString("yyyy-MM-dd", from) : "");
		System.out.println("toDate: "+to != null ? Utils.dateToString("yyyy-MM-dd", to) : "");
		try {
			URIBuilder builder = new URIBuilder(apiUrl+"/everything");
			builder.setParameter("apiKey", apiKey);
			builder.setParameter("q", q);
			builder.setParameter("from", from != null ? Utils.dateToString("yyyy-MM-dd", from) : "");
			builder.setParameter("to", to != null ? Utils.dateToString("yyyy-MM-dd", to) : "");
			builder.setParameter("sortBy", sortBy);
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(builder.build());
			System.out.println("query string => : "+get.toString());
			HttpResponse response = client.execute(get);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			//System.out.println("query response => : "+result.toString());
			return (NewsResponse) readReponse(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return new NewsResponse();
		}
	}
	
	private static Object readReponse(String xmlStr)
			throws JsonParseException, JsonMappingException, JsonGenerationException, IOException {
		Gson gsonObj = new Gson();
		NewsResponse response = gsonObj.fromJson(xmlStr, NewsResponse.class);
		HashMap<?, ?> map = gsonObj.fromJson(xmlStr, HashMap.class);
		try {
			Type listType = new TypeToken<ArrayList<ResponseData>>(){}.getType();
			response.getArticles().addAll(gsonObj.fromJson(gsonObj.toJson(map.get("data")), listType));
		} catch (Exception e) {
			if (map.get("data") != null) {
				response.getArticles().addAll(Arrays.asList(gsonObj.fromJson(gsonObj.toJson(map.get("data")), ResponseData.class)));
			}
		}
//		Response
//		System.out.println("Response : "+response.toString());
//		for(ResponseData vo: response.getArticles())
//			System.out.println("VO: "+vo.toString());
		return response;
	}
	
}
