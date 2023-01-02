package com.stackroute.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import com.stackroute.mvc.model.News;

public class NewsRepository  
{	
	public List<News> newsdata;
	
	public NewsRepository()
	{
		this.newsdata = new ArrayList();
	}
	
	public List<News> getNewsData()
	{
		return newsdata;
	}
	
	public void setNews(List<News> newsdata)
	{
		this.newsdata = newsdata;
	}
	
	public void addNews(News news)
	{
		this.newsdata.add(news);
	}
	
	public void deleteNews(int newsId)
	{
		this.newsdata.remove(newsId);
	}
	
	public void updateNews(News news)
	{
		this.newsdata.add(news);
	}
}
