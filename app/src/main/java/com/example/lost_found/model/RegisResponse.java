package com.example.lost_found.model;

import com.google.gson.annotations.SerializedName;

public class RegisResponse{

	@SerializedName("kontak")
	private String kontak;

	@SerializedName("password")
	private String password;

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("token")
	private String token;

	public void setKontak(String kontak){
		this.kontak = kontak;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setToken(String token){
		this.token = token;
	}
}