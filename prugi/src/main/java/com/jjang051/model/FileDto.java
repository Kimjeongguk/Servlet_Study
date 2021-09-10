package com.jjang051.model;


public class FileDto {
	int no;
	private String contents01;
	private String contents02;
	private String visual;
	private String realVisual;
	public FileDto() {

	}
	public FileDto(int no, String contents01, String contents02, String visual, String realVisual) {
		super();
		this.no = no;
		this.contents01 = contents01;
		this.contents02 = contents02;
		this.visual = visual;
		this.realVisual = realVisual;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContents01() {
		return contents01;
	}
	public void setContents01(String contents01) {
		this.contents01 = contents01;
	}
	public String getContents02() {
		return contents02;
	}
	public void setContents02(String contents02) {
		this.contents02 = contents02;
	}
	public String getVisual() {
		return visual;
	}
	public void setVisual(String visual) {
		this.visual = visual;
	}
	public String getRealVisual() {
		return realVisual;
	}
	public void setRealVisual(String realVisual) {
		this.realVisual = realVisual;
	}
	@Override
	public String toString() {
		return "FileDto [no=" + no + ", contents01=" + contents01 + ", contents02=" + contents02 + ", visual=" + visual
				+ ", realVisual=" + realVisual + "]";
	}

}





