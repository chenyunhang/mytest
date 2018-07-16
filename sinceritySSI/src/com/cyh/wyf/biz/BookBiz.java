package com.cyh.wyf.biz;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyh.wyf.dao.BookDao;
import com.cyh.wyf.entity.TBook;


@Service("bookBiz")
@Transactional(readOnly=true)
public class BookBiz {
	@Autowired
	private BookDao bookDao;
	
	/**
	 * 
	 * @param book
	 * @throws Exception
	 */
	public void addBook(Map bookMap) throws Exception{
	
			bookDao.addBook(bookMap);
				
	}
	
	
	/**
	 * 主页显示，所有图书信息
	 * @return
	 * @throws Exception
	 */
	public List<TBook> getAllBooks() throws Exception{
		
		return bookDao.getAllBooks();		
	}
	
	/**
	 * 根据指定的isbn，提取对应的图片
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public byte[] getBookPic(String isbn) throws Exception{
		return bookDao.getBookPic(isbn);
	}
	
	/**
	 * 根据书号提取书的详细信息(不含图片信息)
	 * @return
	 * @throws Exception
	 */
	public TBook getBookDetail(String isbn) throws Exception{
		return bookDao.getBookDetail(isbn);
	}
	
	/**
	 * 根据书的主键信息，提取所有图书信息
	 * @param isbns
	 * @return
	 * @throws Exception
	 */
	public List<TBook> getBooks(Set<String> isbns) throws Exception{
		List<TBook> books = null;
		if(isbns.size() > 0){
				books = bookDao.getBooks(isbns);
			}
		return books;
	}

}
