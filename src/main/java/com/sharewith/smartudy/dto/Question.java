package com.sharewith.smartudy.dto;
import java.util.ArrayList;
import java.util.Date;

public class Question {
	private int id;
	private String grp;
    private String title;
    private String content;
    private String hashtag;
    private String image1;
    private String money;
    private String time;

    public String getGrp() {
		return grp;
	}
	public void setGrp(String grp) {
		this.grp = grp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
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
	@Override
	public String toString() {
		return "Question [id=" + id + ", grp=" + grp + ", title=" + title + ", content=" + content + ", hashtag="
				+ hashtag + ", image1=" + image1 + ", money=" + money + ", time=" + time + "]";
	}
    
    
}
