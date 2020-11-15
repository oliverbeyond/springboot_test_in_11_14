package com.wn.mapper;

import com.wn.pojo.Book;

import java.util.List;

public interface BookMapper {
    /*admin查看所有图书*/
    List<Book> selectBook();
    int deleteBook(Integer id);
}
