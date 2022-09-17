package com.news.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.service.NewsApiService;
import com.news.service.ResponseDataService;

@Controller
public class HomeController {
	
	@Autowired
	private ResponseDataService responseDataService;

	@RequestMapping({"","/"})
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute("responseData", responseDataService.findAllLimit("5"));
		return "index";
	}
	
	@RequestMapping("/demo")
	public String indexBackup(HttpServletRequest request) {
//		System.out.println("VO: "+newsApiService.everything("apple", null, null, "").toString());
		return "indexBackup";
	}
	
}
