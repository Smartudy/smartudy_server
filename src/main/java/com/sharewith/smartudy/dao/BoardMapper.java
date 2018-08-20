package com.sharewith.smartudy.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sharewith.smartudy.dto.MultipartDto;
import com.sharewith.smartudy.dto.Question;

public interface BoardMapper {
	
	public void Insert(HashMap<String,String> map);
	public ArrayList<Question> getQuestions(@Param("category") String category,@Param("page") int page);
	@Select("SELECT COUNT(*) FROM BOARD WHERE CATEGORY = #{category}")
	public String getQuestionCount(String category);
}
