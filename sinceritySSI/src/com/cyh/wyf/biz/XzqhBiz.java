package com.cyh.wyf.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyh.wyf.dao.XzqhDao;
import com.cyh.wyf.entity.TArea;
import com.cyh.wyf.entity.TCity;
import com.cyh.wyf.entity.TProvince;

@Service("xzqhBiz")
@Transactional(readOnly=true)
public class  XzqhBiz{
	@Autowired
	private XzqhDao xzqhDao;
	
	/**
	 * 获得所有省份列表
	 * @return
	 * @throws Exception
	 */
	public List<TProvince> getAllProvince() throws Exception{
		return xzqhDao.getAllProvince();
	}
	/**
	 * 获得所有市级列表
	 * @param code_p 
	 * @return
	 * @throws Exception
	 */
	public List<TCity> getAllCity(String code_p) throws Exception{
		return xzqhDao.getAllCity(code_p);
	}
	/**
	 * 获得所有市级列表
	 * @return
	 * @throws Exception
	 */
	public List<TArea> getAllArea(String code_c) throws Exception{
		return xzqhDao.getAllArea(code_c);
	}
	
}
