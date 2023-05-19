package com.softusing.jiaokaibo.controller;

import com.softusing.jiaokaibo.domain.Book;
import com.softusing.jiaokaibo.service.BookServiceImps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BookApp {
    @Autowired
    private BookServiceImps bookInterFace;

    //查询书单信息
//    @GetMapping("/books")
//    public List<Book> getAll() {
//        return bookInterFace.findAll();
//    }

    //新增一个书单信息
    @PostMapping("/books")
    public int post(Book book) {
      /*  Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);
*/
        return bookInterFace.save(book);
    }


    //获取一个书单信息
    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id) {

        return bookInterFace.findOne(id);
    }

    //更改一个书单
    @PutMapping("/books")
    public int updata(@RequestParam long id,
                       @RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String description,
                       @RequestParam int status) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookInterFace.save(book);
    }

    //删除一个书单
    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id) {
        bookInterFace.deleteOne(id);
    }


/*
    @PostMapping("/books/by")
    public List<Book> findBy(@RequestParam int len) {
        //   return bookService.findByAuthor(author);
        //return  bookService.findByAuthorAndStatus(author,status);
        //return  bookService.findByDescriptionEndWith(description);
         return  bookService.findByJPQL(len) ;
    }

*/


}
