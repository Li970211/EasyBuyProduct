package com.lijia.domain;

import java.io.Serializable;

public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int userId;//用户Id
	private int productId;//商品Id
	private int quantity;//商品数量
	private double cost;//一个商品的价格
	private Product product;//商品对象
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public Cart() {
		super();
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", productId=" + productId + ", quantity=" + quantity
				+ ", cost=" + cost + ", product=" + product + "]";
	}
	
	
	
}
