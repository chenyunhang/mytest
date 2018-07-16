package com.cyh.wyf.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyh.wyf.dao.batis.BookMapper;
import com.cyh.wyf.entity.TBook;

@Repository("bookDao")
public class BookDao extends BaseDao{
	@Autowired
	private BookMapper bookMapper;
	
	/**
	 * 
	 * @param book
	 * @throws Exception
	 */
	public void addBook(Map bookMap) throws Exception{	
		bookMapper.addBook(bookMap);
	}
	
	/**
	 * 主页显示，所有图书信息
	 * @return
	 * @throws Exception
	 */
	public List<TBook> getAllBooks() throws Exception{
		
		return bookMapper.getAllBooks() ;
	}
	
	/**
	 * 根据指定的isbn，提取对应的图片
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public byte[] getBookPic(String isbn) throws Exception{		
		
		TBook book = bookMapper.getBookPic(isbn);
		
		return book.getPic();
	}
	
	/**
	 * 根据书号提取书的详细信息（不含图片信息）
	 * @return
	 * @throws Exception
	 */
	public TBook getBookDetail(String isbn) throws Exception{		
		
		return bookMapper.getBookDetail(isbn);
	}
	
	

	/**
	 * 根据书的主键信息，提取所有图书信息
	 * @param isbns
	 * @return
	 * @throws Exception
	 */
	public List<TBook> getBooks(Set<String> isbns) throws Exception{
		
		return bookMapper.getCarBooks(isbns);
	}




}
