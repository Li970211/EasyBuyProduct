package com.lijia.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.lijia.dao.Categorydao;
import com.lijia.dao.Productdao;
import com.lijia.dao.Impl.CategorydaoImpl;
import com.lijia.dao.Impl.ProductdaoImpl;
import com.lijia.domain.Category;
import com.lijia.domain.Product;
import com.lijia.service.Categoryservice;

public class categoryserviceImpl implements Categoryservice{

	private Productdao p=new ProductdaoImpl();
	Categorydao cd=new CategorydaoImpl();
	
	@Override
	public List<Category> findfirstcategory() {
		try {
			return cd.findfirstcategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> findchild(int id1) {
		try {
			return cd.findchild(id1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findallproduct(int id) {
		try {
			return p.findallproducts(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
