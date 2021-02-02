package com.wn.pojo;

public class Book {
    private int bookid;
    private String bookname;
    private String writer;
    private String path;
    private int num;
    private String pic;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Book() {
    }

    public Book(String bookname, String writer, String path, int num) {
        this.bookname = bookname;
        this.writer = writer;
        this.path = path;
        this.num = num;
    }

    public Book(int bookid, String bookname, String writer, String path, int num) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.writer = writer;
        this.path = path;
        this.num = num;
    }

    public Book(String bookname, String writer, String path, int num, String pic) {
        this.bookname = bookname;
        this.writer = writer;
        this.path = path;
        this.num = num;
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", writer='" + writer + '\'' +
                ", path='" + path + '\'' +
                ", num=" + num +
                '}';
    }
}
