package com.news.response;

import java.io.Serializable;
import java.util.List;

public class NewsResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String status;
	
	private String totalResults;
	
	private List<ResponseData> articles;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public List<ResponseData> getArticles() {
		return articles;
	}

	public void setArticles(List<ResponseData> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "NewsResponse [status=" + status + ", totalResults=" + totalResults + ", articles=" + articles + "]";
	}
	
	
	
}
