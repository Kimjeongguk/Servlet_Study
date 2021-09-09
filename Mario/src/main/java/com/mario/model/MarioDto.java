package com.mario.model;

public class MarioDto {
	int no;
	String title;
	String contents;
	String bg;
	String link;
	String marioImg;
	String marioRealImag;
	
	public MarioDto() {
	}
	public MarioDto(int no, String title, String contents, String bg, String link, String marioImg,
			String marioRealImag) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.bg = bg;
		this.link = link;
		this.marioImg = marioImg;
		this.marioRealImag = marioRealImag;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getBg() {
		return bg;
	}
	public void setBg(String bg) {
		this.bg = bg;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getMarioImg() {
		return marioImg;
	}
	public void setMarioImg(String marioImg) {
		this.marioImg = marioImg;
	}
	public String getMarioRealImag() {
		return marioRealImag;
	}
	public void setMarioRealImag(String marioRealImag) {
		this.marioRealImag = marioRealImag;
	}
	@Override
	public String toString() {
		return "MarioDto [no=" + no + ", title=" + title + ", contents=" + contents + ", bg=" + bg + ", link=" + link
				+ ", marioImg=" + marioImg + ", marioRealImag=" + marioRealImag + "]";
	}
	
}
