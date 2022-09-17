package com.news.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.news.response.DataSource;

@Entity
@Table(name = "response_data")
public class ResponseDataDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "source_id")
	private DataSourceDto source;
	
	@Column(name="author")
	private String author;
	
	@Column(name="title" ,columnDefinition = "TEXT")
	private String title;
	
	@Column(name="description" ,columnDefinition = "TEXT")
	private String description;
	
	@Column(name="url" ,columnDefinition = "TEXT")
	private String url;
	
	@Column(name="url_to_image" ,columnDefinition = "TEXT")
	private String urlToImage;
	
	private String publishedAt;
	
	@Column(name="content" ,columnDefinition = "TEXT")
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DataSourceDto getSource() {
		return source;
	}

	public void setSource(DataSourceDto source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
