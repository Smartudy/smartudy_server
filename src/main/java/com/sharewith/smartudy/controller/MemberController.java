package com.sharewith.smartudy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sharewith.smartudy.dao.UserMapper;
import com.sharewith.smartudy.dto.AccountDto;
import com.sharewith.smartudy.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	UserMapper dao;
	@Resource
    private Validator validator;
	@Resource
	private MemberService member_service;
    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }
    
	@RequestMapping(value = "/join")
	public @ResponseBody String Join(@Valid AccountDto account,BindingResult result) {
		String error = CheckError(result);
		if(error!=null) return error; //��ǲ�� �߸� �� ���
		
		boolean ismember = member_service.isMember(account.getNickname());
		if(ismember) {
			return null; //�ߺ� ȸ�� ����
		}
		
		member_service.register(account); 
		return makeJSON(account,true);
	}

	@RequestMapping(value = "/login")
	public @ResponseBody String login(AccountDto account,HttpSession session,BindingResult result) {
		
		boolean ismember = member_service.isMember(account.getPhone());
		if(!ismember) {
			session.invalidate();
			return null; //�������� �ʴ� ȸ��
		}
		AccountDto dto = member_service.login(account);
		if(dto != null) { //�α��� ������
			session.setAttribute("login", dto);
			return makeJSON(dto,true);
		}else {//�α��� ���н�
			session.invalidate(); //�α��� �����ÿ��� ���� ���̵� �ȵ���̵�� �Ѿ.
			return makeJSON(null,false);
		}
	}
	
	private String CheckError(BindingResult result)
	{
		boolean error = result.hasErrors();
		ArrayList<String> list = new ArrayList<String>();
		JsonObject root = new JsonObject();//�غ񹰵�
    	root.addProperty("success", !error);
    	if(error) {
    		for(ObjectError err : result.getAllErrors()) {
				root.addProperty("error", err.getDefaultMessage());
				break;
			}
        	return root.toString(); //Input is valid
    	}
    	return null; //Input is not valid
	/*
	  {
		success : true or false,
		errors : {error : ~~}
   	  }
	 */
	}
	 private String makeJSON(AccountDto account,boolean success) { //json���·� account ������ Ŭ���̾�Ʈ�� ����
	    	JsonObject root = new JsonObject();
	    	root.addProperty("success", success);
			if(account!=null && success) { //json ��Ʈ�� -> jsonobject�� ��ȯ�ؼ� root�� �־�� ����� ��.
				String accountjson = new Gson().toJson(account);
				JsonParser parser = new JsonParser();
				JsonObject obj = (JsonObject)parser.parse(accountjson);
				root.add("data", obj);
			}
	    	return root.toString();
	}
	    
}
