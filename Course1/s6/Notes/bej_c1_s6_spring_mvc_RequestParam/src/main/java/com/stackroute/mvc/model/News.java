package com.stackroute.mvc.model;

public class News 
{
	private int newsId;
	private String newsTitle;

	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	

	
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle+"]";
	}
}
