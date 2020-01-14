package com.example.libraryadmin.model;


import com.example.libraryadmin.Utils.FontEmbedder;
import com.google.gson.annotations.SerializedName;


public class Member{

	@SerializedName("student_name")
	private String studentName;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("phnoe_no")
	private String phnoeNo;

	@SerializedName("rollno")
	private String rollno;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("exp_date")
	private String expDate;

	@SerializedName("id")
	private int id;

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

	public void setPhnoeNo(String phnoeNo){
		this.phnoeNo = phnoeNo;
	}

	public String getPhnoeNo(){
		return phnoeNo;
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

	public void setExpDate(String expDate){
		this.expDate = expDate;
	}

	public String getExpDate(){
		return expDate;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}


	@Override
	public String toString() {
		return FontEmbedder.force(studentName);
	}
}