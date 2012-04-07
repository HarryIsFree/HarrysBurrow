package net.harrysburrow.Bean;

import java.util.Date;

public class Blog {

	private String title;
	private String content;
	private String digest;
	private Date   date;
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setDigest(String digest){
		this.digest = digest;
	}
	
	public String getDigest(){
		return this.digest;
	}
	
	public void setDate(Date d){
		this.date = d;
	}
	
	public Date getDate(){
		return this.date;
	}
}
