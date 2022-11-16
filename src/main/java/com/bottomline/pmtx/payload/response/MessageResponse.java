package com.bottomline.pmtx.payload.response;

public class MessageResponse {

	public MessageResponse() {
		super();
	}

	private String message;
	
	public MessageResponse(String message) {
		this.message = message;
	}
	
	public void setMessageResponse(String message) {
		this.message = message;
	}
	
	public String getMessageResponse() {
		return message;
	}

}
