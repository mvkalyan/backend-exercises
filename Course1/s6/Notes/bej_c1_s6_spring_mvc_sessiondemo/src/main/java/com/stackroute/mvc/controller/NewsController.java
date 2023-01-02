package com.stackroute.mvc.controller;

import com.stackroute.mvc.repository.NewsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stackroute.mvc.model.News;

@Controller
public class NewsController 
{

	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	News news = context.getBean("news",News.class);
	NewsRepository newsRepository = context.getBean("newsRepository",NewsRepository.class);
	
	
	public NewsController()
	{
		System.out.println("Employee Controller Instantiated ...");
	}
	
	@GetMapping(path="/")
	public String getNewsHomePage()
	{
		System.out.println("Taking to home Page");
		return "index";
	}
	
	@PostMapping("/saveNews")
	public String saveNews(@ModelAttribute("news") News news,ModelMap model)
	{
		System.out.println("Taking to the save News Page");
		System.out.println("Taking to the save News Page ...."+news);
		
		this.newsRepository.addNews(news);
		model.addAttribute("newsList",this.newsRepository.getNewsData());
		
		return "index";
	}
}