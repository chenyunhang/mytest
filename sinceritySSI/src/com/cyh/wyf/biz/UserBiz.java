package com.cyh.wyf.biz;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyh.wyf.dao.UserDao;
import com.cyh.wyf.dto.BuyRecord;
import com.cyh.wyf.dto.TurnPage;
import com.cyh.wyf.entity.TProvince;
import com.cyh.wyf.entity.TUser;
import com.cyh.wyf.exception.InputNullExcepiton;


@Service("userBiz")
@Transactional(readOnly=true)
public class UserBiz {
	@Autowired
	private UserDao userDao;
	
	/**
	 * 获得所有用户列表
	 * @return
	 * @throws Exception
	 */
	public List<TUser> getUserList(Map userMap) throws Exception{
		return userDao.getUserList(userMap);
	}
	
	/**
	 * 查询用户的购买记录
	 * @return
	 * @throws Exception
	 */
	public List<BuyRecord> getUserBuyRecord(String uname ,
			                          Date beginDate ,Date endDate,TurnPage tp) throws Exception{
			
		
		return userDao.getUserBuyRecord(uname,beginDate,endDate,tp);
	}
	
	/**
	 * 校验输入的用户名，在数据库中是否存在同名
	 * @param uname
	 * @return  true表示重名了
	 * @throws Exception
	 */
	public boolean validUserName(String uname) throws Exception{
			return userDao.validUserName(uname);	
	}
	
	/**
	 * 使用事务控制，进行图书付款
	 * @param uname
	 * @param allMoney
	 * @param books
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void buyBooks(String uname,double allMoney,Map<String,Integer> shopCar) throws Exception{
		
			userDao.updateUserAccount(uname, -allMoney);		
			userDao.addBuyRecord(uname, allMoney, shopCar);
	}
	
	
	
	/**
	 *  登录成功，返回TUser对象
	 * @param uname  
	 * @param pwd
	 * @return
	 */
	public TUser login(String uname,String pwd) throws Exception{
		TUser user = null;
		
		if(uname != null && pwd != null && !uname.equals("") && !pwd.equals("") ){
		    	user = userDao.login(uname, pwd);	
		}else{
			throw new InputNullExcepiton("用户名或密码不能为空");			
		}
		return user;
	}

	/**
	 * 用户注册
	 * @param user
	 * @throws Exception
	 */
	public void regist(Map userMap) throws SQLIntegrityConstraintViolationException,Exception{		
		userDao.addUser(userMap);		
	}
	

}
