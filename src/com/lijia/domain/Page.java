package com.lijia.domain;

import java.util.List;

public class Page {
	//当前页码
	private int nowpage;
	//总页数
	private int sumpage;
	//总记录数
	private int sumcount;
	//首页
	private int firstpage;
	//尾页
	private int lastpage;
	//上一页
	private int prepage;
	//下一页
	private int nextpage;
	//每页显示的记录数
	private int newscount;
	//每页的数据
	private List<News> list;
	public Page() {
		super();
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getSumpage() {
		return sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}
	public int getSumcount() {
		return sumcount;
	}
	public void setSumcount(int sumcount) {
		this.sumcount = sumcount;
	}
	public int getFirstpage() {
		return firstpage;
	}
	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getPrepage() {
		return prepage;
	}
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public int getNewscount() {
		return newscount;
	}
	public void setNewscount(int newscount) {
		this.newscount = newscount;
	}
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}
	
}
