package com.sample.hello;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bean {
	
	
	private int id;
	private String message;
	
	public Bean() {
	}

	public Bean(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	
	public Bean(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}

}
