package com.cyh.wyf.biz;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyh.wyf.dao.EasyUIDao;
import com.cyh.wyf.entity.TUser;


@Service("easyUIBiz")
@Transactional(readOnly=true)
public class EasyUIBiz {
	
	@Autowired
	private EasyUIDao easyUIDao;
	
	/**
	 * 获得所有用户列表
	 * @return
	 * @throws Exception
	 */
	public List<TUser> getAllUser() throws Exception{
		return easyUIDao.getAllUser();
	}
	/**
	 * 修改用户
	 * @return
	 * @throws Exception
	 */
	public void editUser(Map userMap) throws Exception{
		 easyUIDao.editUser(userMap);
	}
	/**
	 * 删除用户
	 * @return
	 * @throws Exception
	 */
	public void delUser(Map userMap) throws Exception{
		 easyUIDao.delUser(userMap);
	}

	

}
