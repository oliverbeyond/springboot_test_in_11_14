package com.wn.controller;

import com.wn.mapper.BookMapper;
import com.wn.pojo.Book;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public class BookController {
    @Autowired
    BookMapper bookMapper;

    /*admin查看所有图书*/
    @RequestMapping("/book")
    public String selectBook(Model model) {
        List<Book> list = bookMapper.selectBook();
        list.forEach(System.out::println);
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
    Object queryUser(@RequestParam("file")MultipartFile file,HttpServletRequest request, HttpSession session) throws Exception {
        HashMap<String, String> res = new HashMap();
        String bookname = request.getParameter("bookname");
        String writer = request.getParameter("writer");
        String path = request.getParameter("path");
        Integer num = Integer.valueOf(request.getParameter("num"));
        //获取随机的图片名
        String picName1 = UUID.randomUUID().toString();
        //获取图片文件
        String filename = file.getOriginalFilename();
        //获取扩展名
        String extName = filename.substring(filename.lastIndexOf("."));
        String picName = picName1+extName;
        //上传图片到本地硬盘
        file.transferTo(new File("D:\\MyPic\\"+picName));
        Book book = new Book(bookname, writer, path, num,picName);
        Integer result = bookMapper.upbook(book);
        if (result == 1) {
            res.put("stateCode", "1");
            return res;
        } else {
            res.put("stateCode", "0");
            return res;
        }
    }

    /*下载,调用浏览器下载功能*/
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           @RequestHeader("User-Agent") String userAgent) throws IOException {
        System.out.println("下载一次 " + filename);
        // 构建File
        File file = new File("D:\\Mypic\\" + File.separator + filename);
        // ok表示http请求中状态码200
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        // 内容长度
        builder.contentLength(file.length());
        // application/octet-stream 二进制数据流（最常见的文件下载）
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        // 使用URLEncoding.decode对文件名进行解码
        filename = URLEncoder.encode(filename, "UTF-8");
        // 根据浏览器类型，决定处理方式
        if (userAgent.indexOf("MSIE") > 0) {
            builder.header("Content-Disposition", "attachment; filename=" + filename);
        } else {
            builder.header("Content-Disposition", "attacher; filename*=UTF-8''" + filename);
        }
        return builder.body(FileUtils.readFileToByteArray(file));
    }
}


