package com.cyh.wyf.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyh.wyf.dao.batis.BookMapper;
import com.cyh.wyf.dao.batis.UserMapper;
import com.cyh.wyf.dto.BuyRecord;
import com.cyh.wyf.dto.TurnPage;
import com.cyh.wyf.entity.TBuyDetail;
import com.cyh.wyf.entity.TBuyRecord;
import com.cyh.wyf.entity.TProvince;
import com.cyh.wyf.entity.TUser;

@Repository("userDao")
public class UserDao extends BaseDao{
	@Autowired
	private UserMapper userMapper; 
	
	@Autowired
	private BookMapper bookMapper;
	
	/**
	 * 获得所有用户列表
	 * @return
	 * @throws Exception
	 */
	public List<TUser>  getUserList(Map userMap) throws Exception{
		return userMapper.getUserList(userMap);
	}
	
	/**
	 * 校验输入的用户名，在数据库中是否存在同名
	 * @param uname
	 * @return  true表示重名了
	 * @throws Exception
	 */
	public boolean validUserName(String uname) throws Exception{
		boolean ifRepeat = false;
		
		int count = userMapper.validUserName(uname);
		if(count > 0 )
			ifRepeat = true;
		
		return ifRepeat;	
	}
	public List<BuyRecord> getUserBuyRecord(String uname ,
                                       Date beginDate ,Date endDate,TurnPage tp) throws Exception{
		
		List<BuyRecord> records = null;
		tp.allRows = userMapper.getUserBuyRecordAllCount(uname, beginDate, endDate);				
		tp.allPages = (tp.allRows-1)/tp.rowsOnePage + 1;		
        int iStart,iEnd;               //记录数的起始值和结束值
		if(tp.currentPage > tp.allPages)
			tp.currentPage = tp.allPages;
		iStart = (tp.currentPage-1)*tp.rowsOnePage + 1;
		iEnd = iStart + tp.rowsOnePage;	
		records = userMapper.getUserBuyRecord(uname, beginDate, endDate, iStart, iEnd);
		
	
		return records;
	}
	
	/**
	 * 对用户的账户，进行充值或扣款操作
	 * @param money为整数为充值操作，money为负数为扣款
	 * @throws Exception
	 */
	
	public void updateUserAccount(String uname ,double money) throws Exception{

		userMapper.updateUserAccount(uname, money);
	}
	

	public void addBuyRecord(String uname,double allMoney,Map<String,Integer> shopCar) throws Exception{
		TBuyRecord record = new TBuyRecord();
		record.setUname(uname);
		record.setBuytime(new Date());
		record.setAllmoney(allMoney);
		userMapper.addBuyRecord(record) ;                         //添加购买记录
		Set<String> isbns = shopCar.keySet();
		for(String isbn : isbns){
			TBuyDetail detail = new TBuyDetail();
			detail.setIsbn(isbn);
			detail.setBuycount(shopCar.get(isbn));
			addBuyDetail(detail);
			//throw new Exception("---事务回滚测试-----");
		}
	}
	
	private void addBuyDetail(TBuyDetail detail) throws Exception{
		userMapper.addBuyDetail(detail);
		updateBookCount(detail.getIsbn(),-detail.getBuycount());
	}
	
	/**
	 * 增加库存或减少库存
	 * @param bookCount是正数为增加库存，bookCount是负数为减少库存
	 * @throws Exception
	 */
	
	public void updateBookCount(String isbn,int bookCount) throws Exception{	
		bookMapper.updateBookCount(isbn, bookCount);
	}  
	
	/**
	 * 登录成功，返回TUser对象
	 * @param uname  
	 * @param pwd
	 * @return
	 */
	public TUser login(String uname,String pwd) throws Exception{
		
		return userMapper.login(uname, pwd);
		
	}
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void addUser(Map userMap) throws SQLIntegrityConstraintViolationException,Exception{
		userMapper.addUser(userMap);
	}
	

}
