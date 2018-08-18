package com.lijia.service.Impl;

import java.util.HashMap;
import java.util.Map;

import com.lijia.dao.Productdao;
import com.lijia.dao.Impl.ProductdaoImpl;
import com.lijia.domain.Cart;
import com.lijia.domain.Product;
import com.lijia.service.ProductInfoService;

public class ProductInfoServiceImpl implements ProductInfoService {
	private Productdao productDao = new ProductdaoImpl();
	
	@Override
	public Product findProdctById(int id) {
		Product product = productDao.selectProductById(id);
		return product;
	}

	@Override
	public void addCart(Integer userId,Product product, Integer quantity) {
		//如果购物车中存在这个商品就修改购物车就可以了
		if(productDao.getCartByProductId(userId,product.getId()) != null) {
			Integer num = productDao.getCartProductNum(userId,product.getId());
			productDao.updateCartProdNum(userId, product,quantity+num);
		}else {
			productDao.addCart(userId,product,quantity);
		}
	}

	@Override
	public void updateCartProdNum(Integer userId, Product product, int buyNum) {
		productDao.updateCartProdNum(userId,product,buyNum);
		
	}

	@Override
	public void deleteCartProduct(Integer userId, Product product) {
		productDao.deleteCartProduct(userId,product);
		
	}

	@Override
	public void clearCart(Integer userId) {
		productDao.clearCart(userId);
	}

}
