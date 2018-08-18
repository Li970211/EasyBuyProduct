package com.lijia.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lijia.dao.Categorydao;
import com.lijia.domain.Category;
import com.lijia.domain.Product;
import com.lijia.util.getDB_c3p0;

public class CategorydaoImpl implements Categorydao {

	@Override
	public List<Category> findfirstcategory() throws SQLException {
		// 1,创建一个queryrunner对象
		QueryRunner qr = new QueryRunner(getDB_c3p0.getDatasourse());
		// 2，执行查询语句，返回结果集
		List<Category> list = qr.query("select * from easybuy_product_category where type=1",
				new BeanListHandler<Category>(Category.class));
		return list;
	}

	@Override
	public List<Category> findchild(int id1) throws SQLException {
		// 1,创建一个queryrunner对象
		QueryRunner qr = new QueryRunner(getDB_c3p0.getDatasourse());
		// 2，执行查询语句，返回结果集
		List<Category> list = qr.query("select * from easybuy_product_category where parentId=?",
				new BeanListHandler<Category>(Category.class), id1);
		return list;
	}
}
