package com.lijia.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class getDB_c3p0 {
	//得到一个数据源
	private static ComboPooledDataSource datasourse = new ComboPooledDataSource(); 
	
	//后面在使用 DButil的时候会用到的
	public static ComboPooledDataSource getDatasourse() {
		return datasourse;
	}
	public static void setDatasourse(ComboPooledDataSource datasourse) {
		getDB_c3p0.datasourse = datasourse;
	}
	//从数据原中得到一个连接
	public static Connection getconn(){
		try {
			return datasourse.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器错误");
		}
	}
	//释放资源
	public static void release(ResultSet rs,Statement s,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		rs=null;
		if(s!=null){
			try {
				s.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		s=null;
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		conn=null;
	}
}
