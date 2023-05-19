package com.softusing.jiaokaibo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v2")
public class HelloController {



    /*@Value("${Book.name}")
    private  String name ;
    @Value("${Book.author}")
    private  String author;
    @Value("${Book.isbn}")
    private  String isbn;*/


    //    @Controller
    //    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String hello() {
        return "Hello Spring Boot";
    }

    @GetMapping("/books")
    public Object getAll(@RequestParam("page") int page, @RequestParam(value = "size",defaultValue ="10" ) int size) {

        Map<String, Object> book = new HashMap<>();
        book.put("name", "互联网世界观");
        book.put("isbn", "98772314623432");
        book.put("author", "李善友");

        Map<String, Object> book2 = new HashMap<>();
        book2.put("name", "原始笔记");
        book2.put("isbn", "9873123432");
        book2.put("author", "王二");

        List<Map> contents =new ArrayList<>();
        contents.add(book);
        contents.add(book2);

        Map<String,Object> pagemap=new HashMap<>();
        pagemap.put("page",page);
        pagemap.put("size",size);
        pagemap.put("contents",contents);
        return pagemap;
    }


    @GetMapping("books/{id}")
    public Object getOne(@PathVariable long id) {
//        System.out.println("id:" + id + "username " + username);
//        Map<String, Object> book = new HashMap<>();
//        book.put("name", "互联网世界观");
//        book.put("isbn", "98772314623432");
//        book.put("author", "李善友");
//        book.put("username", username);

        return null;
    }

    @PostMapping("/books")
    public  Object post(@RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("isbn") String isbn){
        Map<String,Object> book =new HashMap<>();
        book.put("name",name);
        book.put("author",author);
        book.put("isbn",isbn);
        return book;
    }



}
