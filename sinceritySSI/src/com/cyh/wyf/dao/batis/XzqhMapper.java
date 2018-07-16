package com.cyh.wyf.dao.batis;

import java.util.List;

import com.cyh.wyf.entity.TArea;
import com.cyh.wyf.entity.TCity;
import com.cyh.wyf.entity.TProvince;

public interface XzqhMapper{
	
	/**
	 * 读取用省份列表
	 * @return
	 * @throws Exception
	 */
	public List<TProvince> getAllProvince() throws Exception;
	
	/**
	 * 读取用市级列表
	 * @return
	 * @throws Exception
	 */
	public List<TCity> getAllCity(String code_p) throws Exception;
	
	/**
	 * 读取用区域列表
	 * @return
	 * @throws Exception
	 */
	public List<TArea> getAllArea(String code_c) throws Exception;
	
}
