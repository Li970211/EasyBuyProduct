package com.lijia.dao;

import java.util.List;

import com.lijia.domain.Cart;
import com.lijia.domain.Order;
import com.lijia.domain.User;

public interface UserDao {
	/**
	 * 查询用户，判断登录的用户名和密码是匹配，
	 * @param username 用户名
	 * @param password 密码
	 * @return 正确返回user，否则返回null
	 */
	User selectUser(String username, String password);
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @return 查到对应的用户返回，没有则null;
	 */
	User findUserByName(String userName);
	/**
	 * 添加用户
	 * @param user 要添加的用户信息
	 */
	void addUser(User user);
	/**
	 * 根据用户的id查询购物车记录
	 * @param id 用户id
	 * @return
	 */
	List<Cart> getCartByUserId(Integer id);


}
