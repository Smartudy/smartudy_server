package com.sharewith.smartudy.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.sharewith.smartudy.dao.UserMapper;
import com.sharewith.smartudy.dao.BoardMapper;
import com.sharewith.smartudy.dto.AccountDto;
import com.sharewith.smartudy.dto.MultipartDto;
import com.sharewith.smartudy.dto.Question;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BoardService {
	BoardMapper dao;
	UserMapper dao2;
	public void setDao(BoardMapper dao) {
		this.dao = dao;
	}
	public void setDao2(UserMapper dao) {
		this.dao2 = dao;
	}
	public String getQuestionCount(String category) {
		String count = dao.getQuestionCount(category);
		JSONObject obj = new JSONObject();
		obj.put("count", count);
		return obj.toString();
	}
	
	public String getQuestions(String category,String page) {
		ArrayList<Question> list = dao.getQuestions(category,Integer.parseInt(page));
		JSONObject obj = new JSONObject();
		if(list != null) {
			obj.put("success", true);
			JSONArray arr = JSONArray.fromObject(list);
			obj.put("datas", arr);
		}else {
			obj.put("success", false);
		}
		return obj.toString();
	}
	
	public boolean insert(MultipartDto dto,HttpServletRequest request) {
		String text,imagepath,audiopath,drawpath = "";
		HashMap<String,String> map = new HashMap<String,String>();
		System.out.println(dto.toString());
		HttpSession session = request.getSession();
		map.put("title",dto.getTitle());
		map.put("content",dto.getContent());
		map.put("subject", dto.getSubject());
		map.put("money",dto.getMoney());
		map.put("hashtag",dto.getHashtag());
		map.put("category", dto.getCategory());
		if(session != null) {
			AccountDto account = (AccountDto)session.getAttribute("login");
			if(account == null) {
				System.out.println("세션이 존재하지 않습니다.");
				//return false;
				map.put("userid","-1");
			}else {
				map.put("userid",String.valueOf(dao2.findIdByPhone(account.getPhone())));
			}
		}
		int a = 1,b = 1,c = 1;
		if(dto.getImages() != null) {
			for(MultipartFile e : dto.getImages()) {
				try {
					imagepath = storeFiles(e, request, 1);
				}catch(Exception exception) {
					exception.printStackTrace();
					return false;
				}
				System.out.println(imagepath+"에 이미지 저장");
		    	//C:\Users\Simjae\apache-tomcat-8.0.53-windows-x64 (1)\apache-tomcat-8.0.53\wtpwebapps\smartudy_server\images\
		    	map.put("image"+a++,e.getOriginalFilename());
			}
		}
		if(dto.getAudios() != null) {
			for(MultipartFile e : dto.getAudios()) {
				try {
					audiopath = storeFiles(e, request, 2);
				}catch(Exception exception) {
					exception.printStackTrace();
					return false;
				}
				System.out.println(audiopath+"에 오디오 저장");
		    	map.put("audio"+b++,e.getOriginalFilename());
			}
		}
		if(dto.getDraws() != null) {
			for(MultipartFile e : dto.getDraws()) {
				try {
					drawpath = storeFiles(e, request, 3);
				}catch(Exception exception) {
					exception.printStackTrace();
					return false;
				}
				System.out.println(drawpath+"에 그림 저장");
		    	map.put("draw"+c++,e.getOriginalFilename());
			}
		}
		dao.Insert(map);
		return true;
	}
	
	private String storeFiles(MultipartFile e,HttpServletRequest request,int type) throws Exception {
		String uploadPath = "";
		if(type == 1) 
			uploadPath = request.getSession().getServletContext().getRealPath("/images/"); //ServletContext/upload 디렉토리 절대경로;//이미지 파일
		else if(type == 2) //오디오 파일
			uploadPath = request.getSession().getServletContext().getRealPath("/audios/"); //ServletContext/upload 디렉토리 절대경로
		else
			return null;
		
	    File file = new File(uploadPath,e.getOriginalFilename());
    	if(!file.exists())
    		file.mkdirs();
    	try {
			e.transferTo(file);
		}catch (Exception exception) {
			throw exception;
		}
    	return file.getAbsolutePath();
	}
}
