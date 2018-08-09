package com.sharewith.smartudy.dto;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class MultipartDto {
	String title;
	String content;
	ArrayList<MultipartFile> images;
	MultipartFile audio;
	
	
	
	public ArrayList<MultipartFile> getImages() {
		return images;
	}
	public void setImages(ArrayList<MultipartFile> images) {
		this.images = images;
	}
	public MultipartFile getAudio() {
		return audio;
	}
	public void setAudio(MultipartFile audio) {
		this.audio = audio;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
