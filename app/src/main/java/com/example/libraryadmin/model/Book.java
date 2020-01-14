package com.example.libraryadmin.model;


import com.example.libraryadmin.Utils.FontEmbedder;
import com.google.gson.annotations.SerializedName;


public class Book {

	@SerializedName("image")
	private String image;

	@SerializedName("author")
	private Author author;

	@SerializedName("edition")
	private String edition;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("title")
	private String title;

	@SerializedName("recommand")
	private String recommand;

	@SerializedName("category_id")
	private int categoryId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("publisher")
	private String publisher;

	@SerializedName("id")
	private int id;

	@SerializedName("author_id")
	private int authorId;

	@SerializedName("category")
	private Category category;

	@SerializedName("status")
	private int status;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setAuthor(Author author){
		this.author = author;
	}

	public Author getAuthor(){
		return author;
	}

	public void setEdition(String edition){
		this.edition = edition;
	}

	public String getEdition(){
		return edition;
	}

	public void setCreatedAt(Object createdAt){
		this.createdAt = createdAt;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setRecommand(String recommand){
		this.recommand = recommand;
	}

	public String getRecommand(){
		return recommand;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setPublisher(String publisher){
		this.publisher = publisher;
	}

	public String getPublisher(){
		return publisher;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAuthorId(int authorId){
		this.authorId = authorId;
	}

	public int getAuthorId(){
		return authorId;
	}

	public void setCategory(Category category){
		this.category = category;
	}

	public Category getCategory(){
		return category;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return FontEmbedder.force(title);
	}
}