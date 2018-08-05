package com.sharewith.smartudy.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sharewith.smartudy.dto.AccountDto;

public interface UserMapper {
	//아래 처럼 바로 애노테이션으로 SQL 작성해도 되고 DAO 폴더 밑에 매퍼 XML파일 만들어도 됨. 둘다 작동함
	
	@Select("SELECT * FROM account WHERE phone = #{str}")
	AccountDto getUser(String PhoneOrNick);
	
	@Insert("insert into account(nickname,password,major,grade,phone) values (#{nickname},#{password},#{major},#{grade},#{phone})")
	void insert(AccountDto account);
	
	@Select("SELECT COUNT(*) FROM account WHERE nickname = #{str} OR phone = #{str}")
	int isMember(@Param("str") String str);
}
