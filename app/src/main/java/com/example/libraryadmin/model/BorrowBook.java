package com.example.libraryadmin.model;


import com.google.gson.annotations.SerializedName;


public class BorrowBook {

	@SerializedName("member_id")
	private int memberId;

	@SerializedName("date")
	private String date;

	@SerializedName("student_name")
	private String studentName;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("author")
	private String author;

	@SerializedName("book")
	private Book book;

	@SerializedName("rollno")
	private String rollno;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("book_id")
	private int bookId;

	@SerializedName("title")
	private String title;

	@SerializedName("status")
	private int status;

	@SerializedName("return_date")
	private Object returnDate;

	public void setMemberId(int memberId){
		this.memberId = memberId;
	}

	public int getMemberId(){
		return memberId;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setStudentName(String studentName){
		this.studentName = studentName;
	}

	public String getStudentName(){
		return studentName;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setBook(Book book){
		this.book = book;
	}

	public Book getBook(){
		return book;
	}

	public void setRollno(String rollno){
		this.rollno = rollno;
	}

	public String getRollno(){
		return rollno;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBookId(int bookId){
		this.bookId = bookId;
	}

	public int getBookId(){
		return bookId;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public void setReturnDate(Object returnDate){
		this.returnDate = returnDate;
	}

	public Object getReturnDate(){
		return returnDate;
	}

}