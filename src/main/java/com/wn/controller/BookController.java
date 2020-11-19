package com.wn.controller;

import com.wn.mapper.BookMapper;
import com.wn.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookMapper bookMapper;

    /*admin查看所有图书*/
    @RequestMapping("/book")
    public String selectBook(Model model) {
        List<Book> list = bookMapper.selectBook();
        model.addAttribute("book", list);
        return "admin_book2";
    }

    /*admin删除图书*/
    @RequestMapping("/deletebook")
    public String deleteBook(Integer bookid) {
        bookMapper.deleteBook(bookid);
        return "redirect:pages?pageNo=1&pagecurrent=1";
    }

    /*分页查询关键代码*/
    @RequestMapping("/pages")
    public String pages(Integer pageNo, Model model, Integer pagecurrent) {
        if (pageNo == null) {
            pageNo = 1;
        }
        /*一共多少条数据*/
        int total = bookMapper.total();
        /*这些数据需要分几页*/
        int pagesnum = ((total + 3) - 1) / 3;
        /*limit第一个数字是[(页码+每页几条)-1]÷3,第二个数字是每页几条*/
        pageNo = (pageNo - 1) * 3;
        /*传给mapper的值,根据当前页来搜索当前页应该有的内容*/
        List<Book> list = bookMapper.pages(pageNo);
        model.addAttribute("pages", list);
        model.addAttribute("pagesnum", pagesnum);
        /*把当前页存了,为了上下页用*/
        model.addAttribute("pagecurrent", pagecurrent);
        return "admin_book2";
    }


    /*上传书跳转*/
    @RequestMapping("/upbooks")
    public String upbooks(){
        return "admin_upbook";
    }
    /*上传书*/
    @RequestMapping("upbook")
    /*加上@Responsebody后，会直接返回json数据*/
    public @ResponseBody
    Object queryUser(HttpServletRequest request, HttpSession session) throws Exception {
        HashMap<String, String> res = new HashMap();
        String bookname = request.getParameter("bookname");
        String writer = request.getParameter("writer");
        String path = request.getParameter("path");
        Integer num = Integer.valueOf(request.getParameter("num"));
        String picName = null;
        Book book = new Book(bookname, writer, path, num);
        Integer result = bookMapper.upbook(book);
        if (result == 1) {
            res.put("stateCode", "1");
            return res;
        } else {
            res.put("stateCode", "0");
            return res;
        }
    }
}


