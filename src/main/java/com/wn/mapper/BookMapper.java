package com.wn.mapper;

import com.wn.pojo.Book;
import com.wn.pojo.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface BookMapper {
    /*admin查看所有图书*/
    List<Book> selectBook();
    int deleteBook(Integer id);
    /*分页*/
    List<Book> pages(Integer pageNo);
    Integer total();
    @Insert("insert into book(bookname,writer,path,num) values(#{bookname},#{writer},#{path},#{num})")
    Integer upbook(Book book);
}
