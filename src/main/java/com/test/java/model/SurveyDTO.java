package com.test.java.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SurveyDTO {
	
	private String seq;
	private String question;
	private String item1;
	private String item2;
	private String item3;
	private String item4;
	private int cnt1;
	private int cnt2;
	private int cnt3;
	private int cnt4;

}
