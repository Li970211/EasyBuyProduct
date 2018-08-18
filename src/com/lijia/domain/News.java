package com.lijia.domain;

import java.io.Serializable;
/**
  * 新闻类
 * @author 李嘉
 *
 */
import java.sql.Date;
public class News implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;//新闻id
	private String title;//新闻标题
	private String content;//新闻内容
	private Date createTime;//发布时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime + "]";
	}
	
}
