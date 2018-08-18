package com.lijia.service;

import com.lijia.domain.Cart;
import com.lijia.domain.Product;

public interface ProductInfoService {

	/**
	 * 	通过商品id查询对应的商品
	 * @param id 需要查询商品的id
	 * @return 如果查到对应的商品，则将其返回，如果没有查询到则返回null
	 */
	Product findProdctById(int id);
	/**
	 * 将购物车中的信息写入数据库中
	 * @param userId 用户id
	 * @param product 商品对象
	 * @param quantity 商品数量
	 */
	void addCart(Integer userId,Product product, Integer quantity);
	/**
	 *  修改购物车的数量
	 * @param userId
	 * @param product
	 * @param buyNum
	 */
	void updateCartProdNum(Integer userId, Product product, int buyNum);
	/**
	 * 删除购物车的商品
	 * @param userId 用户id
	 * @param product 商品
	 */
	void deleteCartProduct(Integer userId, Product product);
	/**
	 * 清空用户的id
	 * @param userId 用户的id
	 */
	void clearCart(Integer userId);

}
