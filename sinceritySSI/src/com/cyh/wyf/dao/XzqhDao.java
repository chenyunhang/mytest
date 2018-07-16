package com.cyh.wyf.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyh.wyf.dao.batis.XzqhMapper;
import com.cyh.wyf.entity.TArea;
import com.cyh.wyf.entity.TCity;
import com.cyh.wyf.entity.TProvince;

@Repository("xzqhDao")
public class XzqhDao extends BaseDao{
	@Autowired
	private XzqhMapper xzqhMapper; 
	
	
	/**
	 * 获得所有省份列表
	 * @return
	 * @throws Exception
	 */
	public List<TProvince> getAllProvince() throws Exception{
		return xzqhMapper.getAllProvince();
	}
	/**
	 * 获得所有省份列表
	 * @return
	 * @throws Exception
	 */
	public List<TCity> getAllCity(String code_p) throws Exception{
		return xzqhMapper.getAllCity(code_p);
	}
	/**
	 * 获得所有省份列表
	 * @return
	 * @throws Exception
	 */
	public List<TArea> getAllArea(String code_c) throws Exception{
		return xzqhMapper.getAllArea(code_c);
	}
}
