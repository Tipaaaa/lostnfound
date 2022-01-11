package com.example.lost_found.model;

import com.google.gson.annotations.SerializedName;

public class ClaimResponse{

	@SerializedName("message")
	private String message;

	public String getMessage(){
		return message;
	}
}