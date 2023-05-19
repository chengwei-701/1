package com.softusing.jiaokaibo.controller;

import com.softusing.jiaokaibo.domain.Book;
import com.softusing.jiaokaibo.domain.MyPage;
import com.softusing.jiaokaibo.exception.BookFoundException;
import com.softusing.jiaokaibo.service.BookService;
import com.softusing.jiaokaibo.service.BookServiceImps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookServiceImps bookServiceImps;

    @GetMapping("/books")
    public String list(Model model) {
        List<Book> books = bookServiceImps.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {


        Book book = bookServiceImps.findOne(id);
        if (book==null){
            throw new BookFoundException("书单不存在");
        }
    /*    if (book == null) {
            book = new Book();
        }*/
        Model book1 = model.addAttribute("book", book);
        return "book";
    }


    //跳转input提交页面
    @GetMapping("/books/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    //跳转到更新页面
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookServiceImps.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }

    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes) {
        int sqlnum;
        if (book.getId() == null) {
            sqlnum = bookServiceImps.save(book);
        } else {
            sqlnum = bookServiceImps.update(book);
        }

        if (sqlnum > 0) {
            attributes.addFlashAttribute("message", "<" + book.getName() + ">信息提交成功");
        }
        return "redirect:/books";
    }

    @GetMapping("/books/array")
    public String getBookByArray(@RequestParam(value = "currPage", defaultValue = "1") int currPage, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize, Model model) {
        int totalBooks = bookServiceImps.findAll().size();
        int totalPages = (int) Math.ceil((double) totalBooks / pageSize);
        List<Book> books = bookServiceImps.queryBookByArray(currPage, pageSize);
        model.addAttribute("books", books);
        model.addAttribute("currPage", currPage);
        model.addAttribute("totalPages", totalPages);
        //model.addAttribute("pageSize",pageSize);

        return "books";
    }


}

