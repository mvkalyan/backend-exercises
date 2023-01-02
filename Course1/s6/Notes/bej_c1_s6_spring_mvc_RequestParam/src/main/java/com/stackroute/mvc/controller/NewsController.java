package com.stackroute.mvc.controller;

import com.stackroute.mvc.repository.NewsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
	@RequestMapping(path="/saveNews",method = RequestMethod.POST)
	public  String saveNews(@ModelAttribute("news") News news, ModelMap model){

		model.addAttribute("news",news);
		return "success";
	}

//	public String saveNews(
//			@RequestParam("newsId")int newsId, @RequestParam("newsTitle")String newsTitle , Model model)
//	{
//
////		News n=new News();
////		n.setNewsId(newsId);
////		n.setNewsTitle(newsTitle);
//		System.out.println( "id"+ newsId);
//		System.out.println( "title "+ newsTitle);
//
//		model.addAttribute("newsId",newsId );
//		model.addAttribute("newsTitle",newsTitle);
//		System.out.println("Taking to the save News Page");
//
//		return "success";
//	}
}