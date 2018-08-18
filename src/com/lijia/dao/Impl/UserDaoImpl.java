package com.lijia.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lijia.dao.UserDao;
import com.lijia.domain.Cart;
import com.lijia.domain.Order;
import com.lijia.domain.User;
import com.lijia.util.getDB_c3p0;

public class UserDaoImpl implements UserDao {
	/**
	 * 登录时根据用户和密码查询用户
	 */
	@Override
	public User selectUser(String username, String password) {
		String sql = "select * from easybuy_user where loginName = ? and password = ?";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			return runner.query(sql, new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据用户名查询用户名是否存在
	 */
	@Override
	public User findUserByName(String userName) {
		String sql = "select * from easybuy_user where userName = ?";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			return runner.query(sql, new BeanHandler<User>(User.class),userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 添加用户
	 */
	@Override
	public void addUser(User user) {
		String sql = "insert into easybuy_user values(null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			runner.update(sql,
					user.getLoginName(),
					user.getUserName(),
					user.getPassword(),
					user.getSex(),
					user.getIdentityCode(),
					user.getEmail(),
					user.getMobile(),
					user.getType()
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Cart> getCartByUserId(Integer id) {
		String sql = "select * from product_cart where userId = ?";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			return runner.query(sql, new BeanListHandler<Cart>(Cart.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
