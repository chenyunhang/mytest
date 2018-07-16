package com.cyh.wyf.dao.batis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.cyh.wyf.entity.TBook;

public interface BookMapper {
	
	public List<TBook> getAllBooks() throws Exception;
	public TBook getBookPic(String isbn) throws Exception;
	public TBook getBookDetail(String isbn) throws Exception;
	public List<TBook> getCarBooks(@Param("isbns") Set<String> isbns) throws Exception;   //获得购物车图书详情
	public void updateBookCount(String isbn,int bookCount) throws Exception;    //图书库存调整
	public void addBook(Map bookMap) throws Exception;
}
