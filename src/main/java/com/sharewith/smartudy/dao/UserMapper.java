package com.sharewith.smartudy.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sharewith.smartudy.dto.AccountDto;

public interface UserMapper {
	//�Ʒ� ó�� �ٷ� �ֳ����̼����� SQL �ۼ��ص� �ǰ� DAO ���� �ؿ� ���� XML���� ���� ��. �Ѵ� �۵���
	
	@Select("SELECT * FROM account WHERE phone = #{str}")
	AccountDto getUser(String PhoneOrNick);
	
	@Insert("insert into account(nickname,password,major,grade,phone) values (#{nickname},#{password},#{major},#{grade},#{phone})")
	void insert(AccountDto account);
	
	@Select("SELECT COUNT(*) FROM account WHERE nickname = #{str} OR phone = #{str}")
	int isMember(@Param("str") String str);
}
