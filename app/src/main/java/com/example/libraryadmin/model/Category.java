package com.example.libraryadmin.model;


import com.example.libraryadmin.Utils.FontEmbedder;
import com.google.gson.annotations.SerializedName;

public class Category{

	@SerializedName("category_name")
	private String categoryName;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private int id;

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return FontEmbedder.force(categoryName);
	}

	public void setUpdatedAt(Object updatedAt){
		this.updatedAt = updatedAt;
	}

	public Object getUpdatedAt(){
		return updatedAt;
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
		return FontEmbedder.force(categoryName);
	}
}