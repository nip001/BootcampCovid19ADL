package com.adl.main.model;


public class MockPostModel {
	private String title;
    private String body;
    private String userId;
    private int id;
    
	public MockPostModel() {
		
	}
	public MockPostModel(String title, String body, String userId, int id) {
		
		this.title = title;
		this.body = body;
		this.userId = userId;
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
    
}
