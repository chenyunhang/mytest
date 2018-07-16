package com.cyh.wyf.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyh.wyf.dao.batis.EasyUIMapper;
import com.cyh.wyf.entity.TUser;

@Repository("easyUIDao")
public class EasyUIDao extends BaseDao{
	
	@Autowired
	private EasyUIMapper easyUIMapper;
	/**
	 * 获得所有用户列表
	 * @return
	 * @throws Exception
	 */
	public List<TUser> getAllUser() throws Exception{
		return easyUIMapper.getAllUser();
	}
	/**
	 * 修改用户
	 * @return
	 * @throws Exception
	 */
	public void editUser(Map userMap)throws Exception{
		 easyUIMapper.editUser(userMap);
	}
	/**
	 * 获得所有用户列表
	 * @return
	 * @throws Exception
	 */
	public void delUser(Map userMap) throws Exception{
			easyUIMapper.delUser(userMap);
	}
}
