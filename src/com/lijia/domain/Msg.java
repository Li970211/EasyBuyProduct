package com.lijia.domain;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	//状态码 1代表成功 0 代表失败
	private int state;
	//提示信息
	private String msg;
	//返回的数据
	private Map<String, Object> data = new HashMap<>();
	//处理成功的方法
	public static Msg success() {
		Msg result = new Msg();
		result.setState(1);
		result.setMsg("处理成功");
		return result;
	}
	//处理失败的方法
	public static Msg fail() {
		Msg result = new Msg();
		result.setState(0);
		result.setMsg("处理失败");
		return result;
	}
	//添加处理信息
	public Msg add(String key,Object value) {
		this.getData().put(key, value);
		return this;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
