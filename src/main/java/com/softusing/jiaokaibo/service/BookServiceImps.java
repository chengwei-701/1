package com.softusing.jiaokaibo.service;


import com.softusing.jiaokaibo.domain.Book;

import java.util.List;


public interface BookServiceImps {
    List<Book> queryBookByArray(int currPage, int pageSize);

    //List<Book> findAll();
    int update(Book book);
    int save(Book book);

    Book findOne(long id);
    List<Book> findAll();

    void deleteOne(long id);

}
