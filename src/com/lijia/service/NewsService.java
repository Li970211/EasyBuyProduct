package com.lijia.service;

import java.util.List;

import com.lijia.domain.News;
import com.lijia.domain.Page;

public interface NewsService {
	/**
	  *  分页查询新闻信息方法
	 * @param nowpage 当前的页码数
	 * @param newscount 页面要显示的新闻数
	 * @return 当前页码的所有信息
	 */
	Page newsPageInfo(int nowpage, int newscount);
	/**
	 * 根据新闻id查询新闻的详细信息
	 * @param id 新闻id
	 * @return
	 */
	News getNewsById(int id);
	/**
	 * 查询所有的新闻信息
	 * @return
	 */
	List<News> getAllNews();

}
