package com.lijia.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lijia.dao.Productdao;
import com.lijia.domain.Cart;
import com.lijia.domain.Category;
import com.lijia.domain.Product;
import com.lijia.util.getDB_c3p0;

public class ProductdaoImpl implements Productdao {

	@Override
	public List<Product> findallproducts(int category1Id) throws SQLException {
		QueryRunner qr=new QueryRunner(getDB_c3p0.getDatasourse());
		List<Product> query = qr.query("select * from easybuy_product where categoryLevel1Id=?",new BeanListHandler<Product>(Product.class), category1Id);
		return query;
	}

	@Override
	public Product selectProductById(int id) {
		String sql = "SELECT * FROM easybuy_product WHERE id = ?";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			return runner.query(sql, new BeanHandler<Product>(Product.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addCart(Integer userId,Product product, Integer quantity) {
		String sql = "INSERT INTO product_cart VALUES(null,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			runner.update(sql,userId,product.getId(),quantity,product.getPrice());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCartProdNum(Integer userId, Product product, int buyNum) {
		String sql = "UPDATE product_cart SET quantity = ? WHERE userId = ? AND productId = ?";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			runner.update(sql,buyNum,userId,product.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public void deleteCartProduct(Integer userId, Product product) {
		String sql = "DELETE FROM product_cart  WHERE userId = ? AND productId = ?";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			runner.update(sql,userId,product.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void clearCart(Integer userId) {
		String sql = "DELETE FROM product_cart  WHERE userId = ?";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			runner.update(sql,userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Cart getCartByProductId(Integer userId,int id) {
		String sql = "select * from product_cart where userId = ? and productId = ?";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			return runner.query(sql, new BeanHandler<Cart>(Cart.class),userId,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer getCartProductNum(Integer userId,int id) {
		String sql = "select quantity from product_cart where userId = ? and productId = ?";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			return runner.query(sql,new ScalarHandler<>(1),userId,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delProductNum(int productId, int quantity) {
		String sql = "UPDATE easybuy_product SET stock = stock - ? WHERE id = ?";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			runner.update(sql,quantity,productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
