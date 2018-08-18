package com.lijia.dao;

import java.sql.SQLException;
import java.util.List;

import com.lijia.domain.Cart;
import com.lijia.domain.Product;

public interface Productdao {
	List<Product> findallproducts(int category3Id) throws SQLException;
	/***
	 * 根据商品id查找商品信息
	 * @param id 商品id
	 * @return 查找到的商品，没有则返回null
	 */
	Product selectProductById(int id);
	/**
	 *  将购物信息写入数据库中
	 * @param userId 用户的id
	 * @param productId 商品的id
	 * @param quantity 商品的数量
	 */
	void addCart(Integer userId,Product product, Integer quantity);
	/**
	 * 修改购物车商品的数量
	 * @param userId
	 * @param product
	 * @param buyNum
	 */
	void updateCartProdNum(Integer userId, Product product, int buyNum);
	/**
	 * 删除购物车的单件商品
	 * @param userId 用户id
	 * @param product 商品
	 */
	void deleteCartProduct(Integer userId, Product product);
	/**
	 * 清空用户的购物车
	 * @param userId 用户的id
	 */
	void clearCart(Integer userId);
	/**
	 * 根据商品查询购物车中商品的信息
	 * @param id 商品的id
	 * @return
	 */
	Cart getCartByProductId(Integer userId,int id);
	/**
	 * 根据商品id获取商品的数量
	 * @param id
	 * @return
	 */
	Integer getCartProductNum(Integer userId,int id);
	/**
	 * 生成订单后修改商品的数量
	 * @param productId 商品的id
	 * @param quantity 商品的数量
	 */
	void delProductNum(int productId, int quantity);
	
}
