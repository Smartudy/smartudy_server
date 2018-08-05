package com.sharewith.smartudy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class AccountDto {
	
	@NotBlank(message="�г����� �Է����ּ���")
	@Size(min=2, max=15, message="�г����� 2���̻�, 15�� ���Ϸ� �Է����ּ���")
    private String nickname;
	
	@NotBlank(message="��й�ȣ�� �Է����ּ���")
	@Pattern(regexp="([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9]){8,15}" ,message="��й�ȣ�� Ư�� ���ڸ� ������ ������ 8~15���Դϴ�")
    private String password;

    @NotBlank(message = "��ȭ��ȣ�� �Է����ּ���")
    @Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message = "����ó�� '-'�� �� 10~11�ڸ� �Դϴ�")
    private String phone;
    
    @NotBlank(message = "������ �Է����ּ���")
    private String major;

    @NotBlank(message = "�г��� �Է����ּ���")
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
