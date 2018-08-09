package com.sharewith.smartudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.sharewith.smartudy.dto.MultipartDto;
import com.sharewith.smartudy.service.QnAService;


@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
	QnAService service;
	
	@RequestMapping(value = "/post", method=RequestMethod.POST)
	public @ResponseBody String post(MultipartDto dto,HttpServletRequest request) {
		boolean success = service.insert(dto, request);
		JsonObject root = new JsonObject();
		if(success) {
			root.addProperty("success", true);
		}else {
			root.addProperty("success", false);
		}
		return root.toString();
	}
}
