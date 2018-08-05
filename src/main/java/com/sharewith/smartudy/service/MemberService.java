package com.sharewith.smartudy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sharewith.smartudy.dao.UserMapper;
import com.sharewith.smartudy.dto.AccountDto;

public class MemberService {
	UserMapper dao;
	
	public void setDao(UserMapper dao) {
		this.dao = dao;
	}

	public AccountDto find(String nickname){
		return dao.getUser(nickname);
	}
	
	public boolean isMember(String str) {
		if(dao.isMember(str)>0)
			return true;
		return false;
	}
	
//	public boolean isMemberByNick(String nick) {
//		if(dao.isMemberByNick(nick)>0)
//			return true;
//		return false;
//	}

	public AccountDto login(AccountDto param){
		AccountDto account = (AccountDto)find(param.getPhone());
		if(account != null && account.getPassword().equals(param.getPassword()) ) {
			return account;	
		}
		return null;
	}


	public boolean register(AccountDto account) {
		if((find(account.getPhone()) != null) || (find(account.getNickname()) != null)) //휴대폰번호,닉네임 중복
			return false;
		dao.insert(account);
		return true;
	}


}
