package com.replyboard.model;

import java.util.Date;

public class ReplyDto {
	private int no;
	private String name;
	private String email;
	private String subject;
	private String password;
	private Date regDate;
	private int reGroup;
	private int reStep;
	private int reLevel;
	private int readCount;
	private String contents;
	
	public ReplyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReplyDto(int no, String name, String email, String subject, String password, Date regDate, int reGroup,
			int reStep, int reLevel, int readCount, String contents) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.password = password;
		this.regDate = regDate;
		this.reGroup = reGroup;
		this.reStep = reStep;
		this.reLevel = reLevel;
		this.readCount = readCount;
		this.contents = contents;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getReGroup() {
		return reGroup;
	}
	public void setReGroup(int reGroup) {
		this.reGroup = reGroup;
	}
	public int getReStep() {
		return reStep;
	}
	public void setReStep(int reStep) {
		this.reStep = reStep;
	}
	public int getReLevel() {
		return reLevel;
	}
	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "ReplyDto [no=" + no + ", name=" + name + ", email=" + email + ", subject=" + subject + ", password="
				+ password + ", regDate=" + regDate + ", reGroup=" + reGroup + ", reStep=" + reStep + ", reLevel="
				+ reLevel + ", readCount=" + readCount + ", contents=" + contents + "]";
	}
}
