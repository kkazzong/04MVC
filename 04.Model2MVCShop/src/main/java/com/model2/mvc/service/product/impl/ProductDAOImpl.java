package com.model2.mvc.service.product.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDAO;

@Repository("productDAOImpl")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	public SqlSession sqlSession;
	
	public ProductDAOImpl() {
		System.out.println(":::"+getClass()+" default constr");
	}

	@Override
	public void insertProduct(Product product) throws Exception {
		sqlSession.insert("ProductMapper.insertProduct", product);
	}

	@Override
	public Product findProduct(int prodNo) throws Exception {
		return sqlSession.selectOne("ProductMapper.getProduct", prodNo);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		sqlSession.update("ProductMapper.updateProduct", product);
	}

	@Override
	public List<Product> getProductList(Search search) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("totalCount", sqlSession.selectOne("ProductMapper.getCount", search));
//		map.put("productList",sqlSession.selectList("ProductMapper.getProductList", search));
		return sqlSession.selectList("ProductMapper.getProductList", search);
	}
	
	@Override
	public int getCount(Search search) throws Exception {
		return sqlSession.selectOne("ProductMapper.getCount", search);
	}
	
 	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
