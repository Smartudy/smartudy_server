package com.sharewith.smartudy.dto;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class MultipartDto {
	String title;
	String content;
	String grp;
	String time;
	String money;
	String hashtag;
    String subject;
    String category;
	ArrayList<MultipartFile> images;
	ArrayList<MultipartFile> audios;
	ArrayList<MultipartFile> draws;
	
	public String getGrp() {
		return grp;
	}
	public void setGrp(String grp) {
		this.grp = grp;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public ArrayList<MultipartFile> getImages() {
		return images;
	}
	public void setImages(ArrayList<MultipartFile> images) {
		this.images = images;
	}
	public ArrayList<MultipartFile> getAudios() {
		return audios;
	}
	public void setAudios(ArrayList<MultipartFile> audios) {
		this.audios = audios;
	}
	public ArrayList<MultipartFile> getDraws() {
		return draws;
	}
	public void setDraws(ArrayList<MultipartFile> draws) {
		this.draws = draws;
	}
	@Override
	public String toString() {
		return "MultipartDto [title=" + title + ", content=" + content + ", grp=" + grp + ", time=" + time + ", money="
				+ money + ", hashtag=" + hashtag + ", subject=" + subject + ", category=" + category + ", images="
				+ images + ", audios=" + audios + ", draws=" + draws + "]";
	}
	
	
	
}
