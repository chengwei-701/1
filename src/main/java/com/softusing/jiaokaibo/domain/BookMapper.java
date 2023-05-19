package com.softusing.jiaokaibo.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface BookMapper {
   //创建书单
    int save(Book book);

    //更新书单
    int update(Book book);

    //删除书单
    Book deleteOne(long id);

    //根据id查询
    Book findOne(long id);

    //查询所有用户
    List<Book> findAll();
    List<Book> queryBookByArray();




}
