package com.example.libraryadmin.model;


import com.example.libraryadmin.Utils.FontEmbedder;
import com.example.libraryadmin.Utils.Moulder;
import com.google.gson.annotations.SerializedName;


public class Author{

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private int id;

	public void setUpdatedAt(Object updatedAt){
		this.updatedAt = updatedAt;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCreatedAt(Object createdAt){
		this.createdAt = createdAt;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
	public String toString() {
		return FontEmbedder.force(name);
	}
}