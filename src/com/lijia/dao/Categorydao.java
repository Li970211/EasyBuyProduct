package com.lijia.dao;

import java.sql.SQLException;
import java.util.List;

import com.lijia.domain.Category;
import com.lijia.domain.Product;

public interface Categorydao {

	List<Category> findfirstcategory() throws SQLException;

	List<Category> findchild(int id1) throws SQLException;

}
