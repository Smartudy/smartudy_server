package com.sharewith.smartudy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.sharewith.smartudy.dto.MultipartDto;
import com.sharewith.smartudy.dto.Question;
import com.sharewith.smartudy.service.BoardService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
	BoardService service;
	
	@RequestMapping(value = "/post/question", method=RequestMethod.POST)
	public @ResponseBody String postQuestion(MultipartDto dto,HttpServletRequest request) {
		boolean success = service.insert(dto, request,0);
		JsonObject root = new JsonObject();
		if(success) {
			root.addProperty("success", true);
		}else {
			root.addProperty("success", false);
		}
		return root.toString();
	}
	
	@RequestMapping(value = "/post/answer", method=RequestMethod.POST)
	public @ResponseBody String postAnswer(MultipartDto dto,HttpServletRequest request) {
		boolean success = service.insert(dto, request,1);
		JsonObject root = new JsonObject();
		if(success) {
			root.addProperty("success", true);
		}else {
			root.addProperty("success", false);
		}
		return root.toString();
	}
	
	@RequestMapping(value = "/question", method=RequestMethod.GET)
	public @ResponseBody String getSelectedQuestion(MultipartDto dto,HttpServletRequest request) {
		String id = request.getParameter("id");
		String result = service.getSelectedQuestion(id);
		if(result != null)
			return result;
		return null;
		
	}
	
	@RequestMapping(value = "/answer", method=RequestMethod.GET)
	public @ResponseBody String getAnswers(MultipartDto dto,HttpServletRequest request) {
		String group = request.getParameter("grp");
		String result = service.getAnswers(group);
		if(result != null)
			return result;
		return null;
		
	}
	
	@RequestMapping(value = "/listpage", method=RequestMethod.GET)
	public @ResponseBody String listpage(HttpServletRequest request) {
		String page = request.getParameter("page");
		String category = request.getParameter("category");
		String result = service.getQuestions(category,page);
		if(result != null)
			return result;
		return null;
	}
	
	@RequestMapping(value = "/questioncount", method=RequestMethod.GET)
	public @ResponseBody String getQuestionCount(HttpServletRequest request) {
		String page = request.getParameter("category");
		String result = service.getQuestionCount(page);
		if(result != null)
			return result;
		return null;
	}
	
}
