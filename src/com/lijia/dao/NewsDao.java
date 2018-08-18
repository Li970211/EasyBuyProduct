package com.lijia.dao;

import java.util.List;

import com.lijia.domain.News;

public interface NewsDao {
	/**
	 * 获取新闻的总记录数
	 * @return 总记录数
	 */
	int getNewsCount();
	/**
	 * 查询指定新闻记录数后多少条新闻记录
	 * @param from 第几条开始查询
	 * @param count 查询多少条
	 * @return
	 */
	List<News> getNewsByPage(int from, int count);
	/**
	 * 根据新闻id查询详细信息
	 * @param id 新闻id
	 * @return
	 */
	News getNewsById(int id);
	/**
	 * 获取所有新闻信息
	 * @return
	 */
	List<News> getAllNews();
	
	

}
