package com.sharewith.smartudy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class AccountDto {
	
	@NotBlank(message="닉네임을 입력해주세요")
	@Size(min=2, max=15, message="닉네임은 2자이상, 15자 이하로 입력해주세요")
    private String nickname;
	
	@NotBlank(message="비밀번호를 입력해주세요")
	@Pattern(regexp="([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9]){8,15}" ,message="비밀번호는 특수 문자를 포함한 영문자 8~15자입니다")
    private String password;

    @NotBlank(message = "전화번호를 입력해주세요")
    @Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message = "연락처는 '-'를 뺀 10~11자리 입니다")
    private String phone;
    
    @NotBlank(message = "전공을 입력해주세요")
    private String major;

    @NotBlank(message = "학년을 입력해주세요")
    private String grade;

    public AccountDto() {
    }

	public AccountDto(String nickname, String password, String phone, String major, String grade) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.phone = phone;
		this.major = major;
		this.grade = grade;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "nickname : " + nickname +
				" password : " + password +
				" phone : " + phone +
				" major : " + major +
				" grade : " + grade;
	}

	
    
}
