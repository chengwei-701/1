package com.softusing.jiaokaibo.service;

import com.softusing.jiaokaibo.domain.Book;
import com.softusing.jiaokaibo.domain.BookExample;
import com.softusing.jiaokaibo.domain.MyPage;
import com.softusing.jiaokaibo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceImps {
    @Autowired
    private BookMapper bookMapper;


    public int save(Book book) {
        return bookMapper.insert(book);
    }

    public int update(Book book) {
        return bookMapper.updateByPrimaryKey(book);
    }


    public Book findOne(long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    public void deleteOne(long id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    public List<Book> findAll() {
        return bookMapper.selectByExample(new BookExample());
    }

    public List<Book> queryBookByArray(int currPage, int pageSize) {
        //查询全部数据
        List<Book> book = bookMapper.queryBookByArray();
        //从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
        //到第几条数据结束
        int lastIndex = Math.min(currPage * pageSize, book.size());
        return book.subList(firstIndex, lastIndex); //直接在list中截取
    }
}
