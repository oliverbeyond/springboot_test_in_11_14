package com.wn.controller;

import com.wn.mapper.BookMapper;
import com.wn.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookMapper bookMapper;

    /*admin查看所有图书*/
    @RequestMapping("/book")
    public String selectBook(Model model) {
        List<Book> list = bookMapper.selectBook();
        model.addAttribute("book",list);
        return "admin_book";
    }

    /*admin删除图书*/
    @RequestMapping("/deletebook")
    public String deleteBook(Integer id){
        bookMapper.deleteBook(id);
        return "redirect:book";
    }


}
