package com.example.lost_found.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse{

	@SerializedName("dataUser")
	private List<DataUserItem> dataUser;

	public void setDataUser(List<DataUserItem> dataUser){
		this.dataUser = dataUser;
	}

	public List<DataUserItem> getDataUser(){
		return dataUser;
	}
}