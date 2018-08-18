package com.lijia.service;

import java.util.List;

import com.lijia.domain.Category;
import com.lijia.domain.Product;
import com.sun.xml.internal.bind.v2.model.core.ID;

public interface Categoryservice {

	List<Category> findfirstcategory();

	List<Category> findchild(int id1);

	List<Product> findallproduct(int id);
}
