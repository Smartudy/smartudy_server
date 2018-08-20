package com.sharewith.smartudy.dto;
import java.util.ArrayList;
import java.util.Date;

public class Question {
    private String title;
    private String content;
    private String hashtag;
    private String image1;
    private String money;
    private String time;

    public Question() {
    }
    public Question(String title, String content, String hashtag, String image1, String money, String time) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.image1 = image1;
        this.money = money;
        this.time = time;
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
    public String getHashtag() {
        return hashtag;
    }
    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
    public String getMoney() {
        return money;
    }
    public void setMoney(String money) {
        this.money = money;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getimage1() {
        return image1;
    }
    public void setimage1(String image1) {
        this.image1 = image1;
    }
	@Override
	public String toString() {
		return "Question [title=" + title + ", content=" + content + ", hashtag=" + hashtag + ", image1=" + image1
				+ ", money=" + money + ", time=" + time + "]";
	}
    
    
}
