package com.lijia.domain;

import java.io.Serializable;
/**
 *   订单表信息
 * @author 李嘉
 *
 */
public class OrderListForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderId;//订单编号
	private int productId;//商品id
	private int quantity;//商品数量
	private double cost;//消费
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	@Override
	public String toString() {
		return "OrderListForm [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", cost="
				+ cost + ", product=" + product + "]";
	}
	
	
	
	
}
