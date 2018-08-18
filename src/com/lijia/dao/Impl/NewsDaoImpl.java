package com.lijia.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lijia.dao.NewsDao;
import com.lijia.domain.News;

import com.lijia.util.getDB_c3p0;

public class NewsDaoImpl implements NewsDao {

	@Override
	public int getNewsCount() {
		String sql = "SELECT COUNT(1) FROM easybuy_news";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			return ((Long)runner.query(sql, new ScalarHandler<>())).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<News> getNewsByPage(int from, int count) {
		String sql = "SELECT * FROM easybuy_news ORDER BY createTime DESC LIMIT ?,?";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			return runner.query(sql,new BeanListHandler<News>(News.class),from,count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public News getNewsById(int id) {
		String sql = "SELECT * FROM `easybuy_news` WHERE id = ?";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			return runner.query(sql,new BeanHandler<News>(News.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<News> getAllNews() {
		String sql = "SELECT * FROM easybuy_news ORDER BY createTime DESC";
		try {
			QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
			return runner.query(sql,new BeanListHandler<News>(News.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
