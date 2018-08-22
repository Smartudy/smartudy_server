package com.sharewith.smartudy.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sharewith.smartudy.dto.Answer;
import com.sharewith.smartudy.dto.MultipartDto;
import com.sharewith.smartudy.dto.Question;
import com.sharewith.smartudy.dto.Question_Selected;

public interface BoardMapper {
	
	public void InsertQuestion(HashMap<String,String> map);
	public void InsertAnswer(HashMap<String,String> map);
	public ArrayList<Question> getQuestions(@Param("category") String category,@Param("page") int page);
	public ArrayList<Answer> getAnswers(@Param("grp") String grp);
	@Select("SELECT COUNT(*) FROM Question WHERE CATEGORY = #{category}")
	public String getQuestionCount(String category);
	public Question_Selected getSelectedQuestion(String id);
}
