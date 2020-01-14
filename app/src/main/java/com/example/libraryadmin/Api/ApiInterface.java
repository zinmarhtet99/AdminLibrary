package com.example.libraryadmin.Api;

import com.example.libraryadmin.model.Author;
import com.example.libraryadmin.model.Book;
import com.example.libraryadmin.model.BorrowBook;
import com.example.libraryadmin.model.Category;
import com.example.libraryadmin.model.Member;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("book")
    Call<List<Book>>getBook1();


    @POST("book/status/{status}")
    Call<List<Book>>getAvailableBook(@Path("status") int status);



    @POST("member/insert")
    @FormUrlEncoded
    Call<String>EntryMember(@Field("student_name") String student_name,
                                 @Field("rollno") String rollno,
                                 @Field("exp_date") String exp_date,
                                    @Field("phnoe_no") String phnoe_no


                                 );

    @POST("book/insert")
    @FormUrlEncoded
    Call<String>EntryBook(@Field("title") String title,
                          @Field("author_id") int author_id,
                          @Field("edition") String edition,
                          @Field("publisher") String publisher,
                          @Field("recommand") String recommand,
                          @Field("category_id") int category_id
                        );


    @POST("borrow/insert")
    @FormUrlEncoded
    Call<String>EntryBorrowBook(@Field("student_name") String student_name,
                                @Field("rollno") String rollno,
                                @Field("title") String title,
                                @Field("author") String author,
                                @Field("member_id") int member_id,
                                @Field("book_id") int book_id,
                                @Field("date") String date
                                );
    @GET("borrow")
    Call<List<BorrowBook>>getBorrowBook();

    @POST("borrow/update/{id}")
    @FormUrlEncoded
    Call<String>ReturnBorrowBook(@Path("id") int id,
                                @Field("book_id") int book_id,
                                @Field("return_date") String return_date);
    @GET("author")
    Call<List<Author>>getAllAuthor();

    @GET("category")
    Call<List<Category>>getAllCategory();

    @GET("member")
    Call<List<Member>>getAllMember();

    @POST("borrow/detail/{rollno}")
    Call<List<BorrowBook>>getBorrowBook(@Path("rollno") String rollno);



}
