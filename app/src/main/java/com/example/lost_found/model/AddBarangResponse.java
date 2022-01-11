package com.example.lost_found.model;

import com.google.gson.annotations.SerializedName;

public class AddBarangResponse{

	@SerializedName("pesan")
	private String pesan;

	public String getPesan(){
		return pesan;
	}

	@SerializedName("error")
	private String error;

	public String getError(){
		return error;
	}
}