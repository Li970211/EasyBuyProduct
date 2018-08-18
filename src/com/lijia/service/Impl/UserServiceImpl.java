package com.lijia.service.Impl;

import java.util.List;

import com.lijia.dao.UserDao;
import com.lijia.dao.Impl.UserDaoImpl;
import com.lijia.domain.Cart;
import com.lijia.domain.Msg;
import com.lijia.domain.User;
import com.lijia.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userdao = new UserDaoImpl();
		
	 //登录时根据用户名和密码去匹配用户
	@Override
	public User findUserByNameAndPwd(String username, String password) {
		User user = userdao.selectUser(username,password);
		return user;
	}
	
	
	 //注册
	@Override
	public Msg regist(User user) {
		if(hashName(user.getLoginName())) {
			return Msg.fail().add("message", "用户名已存在");
		}
		//设置用户类型
		user.setType(0);
		//添加用户
		userdao.addUser(user);
		return Msg.success().add("user", user);
	}
	//判断用户名是否重复
	@Override
	public boolean hashName(String loginName) {
		return userdao.findUserByName(loginName)!=null;
	}


	@Override
	public List<Cart> getCartByUserId(Integer id) {
		return userdao.getCartByUserId(id);
	}


	

}
