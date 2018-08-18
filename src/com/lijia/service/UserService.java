package com.lijia.service;

import java.util.List;

import com.lijia.domain.Cart;
import com.lijia.domain.Msg;
import com.lijia.domain.User;

public interface UserService {
	/**
	 * 根据用户名和密码查找对应的用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回对应的用户，没有查找到返回null
	 */
	User findUserByNameAndPwd(String username, String password);
	/**
	 * 注册用户
	 * @param user
	 * 
	 */
	Msg regist(User user);
	/**
	 * 校验用户名是否存在
	 * @param loginName 用户名
	 * @return 存在则返回true,不存在则返回false
	 */
	boolean hashName(String loginName);
	/**
	 * 根据用户id查询用户的购物车
	 * @param id  用户的id
	 * @return  购物车信息
	 */
	List<Cart> getCartByUserId(Integer id);

}
