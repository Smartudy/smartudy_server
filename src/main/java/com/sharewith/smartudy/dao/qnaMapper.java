package com.sharewith.smartudy.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;

import com.sharewith.smartudy.dto.MultipartDto;

public interface qnaMapper {
	
	public void Insert(HashMap<String,String> map);
	
}
