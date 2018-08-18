package com.lijia.domain;

import java.io.Serializable;
import java.util.Date;
/**
 *  订单表
 * @author 李嘉
 *
 */
import java.util.List;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private String orderId;//订单编号
	private int userId;//用户id
	private String userAddress;//地址
	private String createTime;//订单时间
	private double cost;//总消费
	private List<OrderListForm> list;//订单详细
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public List<OrderListForm> getList() {
		return list;
	}
	public void setList(List<OrderListForm> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", userAddress=" + userAddress + ", createTime="
				+ createTime + ", cost=" + cost + ", list=" + list + "]";
	}
	
	
	
}
