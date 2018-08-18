package com.lijia.service.Impl;

import java.util.List;

import com.lijia.dao.NewsDao;
import com.lijia.dao.Impl.NewsDaoImpl;
import com.lijia.domain.News;
import com.lijia.domain.Page;
import com.lijia.service.NewsService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class NewsServiceImpl implements NewsService {
	
	private NewsDao newsDao = new NewsDaoImpl();
	
	@Override
	public Page newsPageInfo(int nowpage, int newscount) {
		Page page = new Page();
		//当前页
		page.setNowpage(nowpage);
		//每页记录数
		page.setNewscount(newscount);
		//新闻的总记录数
		int sumcount = newsDao.getNewsCount();
		page.setSumcount(sumcount);
		//总页数
		int sumpage = sumcount/newscount+(sumcount%newscount==0?0:1);
		page.setSumpage(sumpage);
		//首页
		page.setFirstpage(1);
		//末页
		page.setLastpage(sumpage);
		//上一页
		page.setPrepage(nowpage == 1 ? 1:nowpage-1);
		//下一页
		page.setNextpage(nowpage == sumpage ? sumpage:nowpage+1);
		//获取当页显示的数据
		List<News> list = newsDao.getNewsByPage((nowpage-1)*newscount,newscount);
		page.setList(list);
		return page;
	}

	@Override
	public News getNewsById(int id) {
		return newsDao.getNewsById(id);
	}

	@Override
	public List<News> getAllNews() {
		return newsDao.getAllNews();
	}

}
