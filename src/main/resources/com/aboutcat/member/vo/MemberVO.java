package com.aboutcat.member.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
							
@Data
public class MemberVO {
	
	private String member_id;
	
	private String member_pw;
	
	private String member_name;
	
	private String member_gender;
	
	private String phone;
	
	private Boolean sms_valid_check;
	
	private String member_email1;
	
	private String member_email2;
	
	private Boolean email_valid_check;
	
	private String posecode;
	
	private String address1_new;
	
	private String address1_old;
	
	private String address2;
	
	private int birth_year;

	private int birth_month;
	
	private int birth_day;
	
	private Boolean birth_day_yinyang;
	
	private Date member_add_date;
	
	private int member_deleted;
	
}
