package com.cyh.wyf.dao.batis;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cyh.wyf.entity.TBuyDetail;
import com.cyh.wyf.entity.TBuyRecord;
import com.cyh.wyf.entity.TProvince;
import com.cyh.wyf.entity.TUser;
import com.cyh.wyf.dto.BuyRecord;


public interface UserMapper {
	public TUser login(String uname,String pwd) throws Exception;
	public void updateUserAccount(String uname ,double money) throws Exception;   //更新账户金额
	public void addBuyRecord(TBuyRecord record) throws Exception;    //添加购买记录
	public void addBuyDetail(TBuyDetail detail) throws Exception;    //添加购买明细
	public int getUserBuyRecordAllCount(@Param("uname") String uname,
			     @Param("beginDate") Date beginDate ,@Param("endDate")Date endDate) throws Exception;  //获得用户购买记录的总数量
	
	public List<BuyRecord> getUserBuyRecord(@Param("uname") String uname ,
			@Param("beginDate") Date beginDate , @Param("endDate") Date endDate, 
			@Param("iStart") int iStart, @Param("iEnd") int iEnd) throws Exception;
	
	/**
	 * 读取用户列表
	 * @return
	 * @throws Exception
	 */
//	public List<TUser>  getUserList(@Param("uname")String uanme,@Param("pwd")String pwd) throws Exception;
	public List<TUser>  getUserList(Map userMap) throws Exception;
	
	/**
	 * 用户注册
	 * @param user
	 * @throws SQLIntegrityConstraintViolationException
	 * @throws Exception
	 */
	public void addUser(Map userMap) throws SQLIntegrityConstraintViolationException,Exception;
	
	/**
	 * 检查指定的用户名是否存在
	 * @param uname
	 * @return     0不存在    >0则表示存在
	 * @throws Exception
	 */
	public int validUserName(String uname) throws Exception;
	

	
}
