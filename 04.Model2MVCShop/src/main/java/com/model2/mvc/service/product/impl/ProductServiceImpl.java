package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDAO;
import com.model2.mvc.service.product.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productDAOImpl")
	ProductDAO productDAO;
	
	public ProductServiceImpl() {
		System.out.println(":::"+getClass()+" default constr");
	}

	@Override
	public void insertProduct(Product product) throws Exception {
		productDAO.insertProduct(product);
	}

	@Override
	public Product findProduct(int prodNo) throws Exception {
		return productDAO.findProduct(prodNo);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		productDAO.updateProduct(product);
	}

	@Override
	public Map<String, Object> getProductList(Search search) throws Exception {
		int totalCount = productDAO.getCount(search);
		List<Product> list = productDAO.getProductList(search);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", new Integer(totalCount));
		map.put("list", list);

		return map;
	}
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
}
