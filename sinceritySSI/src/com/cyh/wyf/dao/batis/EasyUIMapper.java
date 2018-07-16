package com.cyh.wyf.dao.batis;

import java.util.List;
import java.util.Map;

import com.cyh.wyf.entity.TUser;



public interface EasyUIMapper {
	/**
	 * 读取用户列表
	 * @return
	 * @throws Exception
	 */
	public List<TUser> getAllUser() throws Exception;
	/**
	 * 修改用户列表
	 * @return
	 * @throws Exception
	 */
	public void editUser(Map userMap) throws Exception;
	
	/**
	 * 删除用户
	 * @return
	 * @throws Exception
	 */
	public void delUser(Map userMap) throws Exception;
	
	
	
}
