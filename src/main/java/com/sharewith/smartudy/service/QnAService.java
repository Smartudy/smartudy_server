package com.sharewith.smartudy.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.sharewith.smartudy.dao.UserMapper;
import com.sharewith.smartudy.dao.qnaMapper;
import com.sharewith.smartudy.dto.AccountDto;
import com.sharewith.smartudy.dto.MultipartDto;

public class QnAService {
	qnaMapper dao;
	UserMapper dao2;
	public void setDao(qnaMapper dao) {
		this.dao = dao;
	}
	public void setDao2(UserMapper dao) {
		this.dao2 = dao;
	}
	public boolean insert(MultipartDto dto,HttpServletRequest request) {
		String text,imagepath,audiopath = "";
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("title",dto.getTitle());
		map.put("content",dto.getContent());
		
		HttpSession session = request.getSession();
		if(session != null) {
			AccountDto account = (AccountDto)session.getAttribute("login");
			if(account == null) {
				System.out.println("세션이 존재하지 않습니다.");
				return false;
			}
			map.put("userid",String.valueOf(dao2.findIdByPhone(account.getPhone())));
		}
		int i=1;
		for(MultipartFile e : dto.getImages()) {
			try {
				imagepath = storeFiles(e, request, 1);
			}catch(Exception exception) {
				exception.printStackTrace();
				return false;
			}
			System.out.println(imagepath+"에 이미지 저장");
	    	//C:\Users\Simjae\apache-tomcat-8.0.53-windows-x64 (1)\apache-tomcat-8.0.53\wtpwebapps\smartudy_server\images\
	    	map.put("image"+i++,e.getOriginalFilename());
		}
		try {
			audiopath = storeFiles(dto.getAudio(),request,2);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println(audiopath+"에 오디오 저장");
		map.put("audio",dto.getAudio().getOriginalFilename());
		dao.Insert(map);
		return true;
	}
	
	private String storeFiles(MultipartFile e,HttpServletRequest request,int type) throws Exception {
		String uploadPath = "";
		if(type == 1) 
			uploadPath = request.getSession().getServletContext().getRealPath("/images/"); //ServletContext/upload 디렉토리 절대경로;//이미지 파일
		else if(type == 2) //오디오 파일
			uploadPath = request.getSession().getServletContext().getRealPath("/audios/"); //ServletContext/upload 디렉토리 절대경로
		
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
