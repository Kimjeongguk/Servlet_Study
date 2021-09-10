package com.clock.model;

public class ClockDto {
	int no;
	String category;
	String title;
	String depth;
	int price;
	String link;
	String clockImg;
	String realClockImg;
	public ClockDto() {
	}
	public ClockDto(int no, String category, String title, String depth, int price, String link, String clockImg,
			String realClockImg) {
		super();
		this.no = no;
		this.category = category;
		this.title = title;
		this.depth = depth;
		this.price = price;
		this.link = link;
		this.clockImg = clockImg;
		this.realClockImg = realClockImg;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getClockImg() {
		return clockImg;
	}
	public void setClockImg(String clockImg) {
		this.clockImg = clockImg;
	}
	public String getRealClockImg() {
		return realClockImg;
	}
	public void setRealClockImg(String realClockImg) {
		this.realClockImg = realClockImg;
	}
	@Override
	public String toString() {
		return "ClockDto [no=" + no + ", category=" + category + ", title=" + title + ", depth=" + depth + ", price="
				+ price + ", link=" + link + ", clockImg=" + clockImg + ", realClockImg=" + realClockImg + "]";
	}
	
	

}
