package mybatis.service.product.test;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDAO;
import com.model2.mvc.service.product.impl.ProductDAOImpl;

public class DaoTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory 
											= new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("\n");
		
		ProductDAOImpl dao = new ProductDAOImpl();
		dao.setSqlSession(sqlSession);
//		System.out.println("::: insert product ::: ");
//		Product product = new Product();
//		product.setProdName("마우스");
//		product.setProdDetail("로지텍마우스");
//		product.setPrice(10000);
//		dao.insertProduct(product);
//		
////		sqlSession.insert("ProductMapper.insertProduct", product);
//		
//		System.out.println("::: update product ::: ");
//		Product product2 = new Product();
//		product2.setProdDetail("마우스업뎃확인");
//		product2.setProdNo(10058);
//		dao.updateProduct(product2);
//		
////		sqlSession.update("ProductMapper.updateProduct", product);
//		
		System.out.println("::: get product :::");
		int prodNo = 10012;
		Product prod = dao.findProduct(prodNo);
////		Product prod = (Product)sqlSession.selectOne("ProductMapper.getProduct", prodNo);
		System.out.println(prod);
//		
		System.out.println("::: getList product :::");
		Search search = new Search();
		search.setPageSize(3);
		search.setCurrentPage(1);
		search.setSearchCondition("");
//		search.setSearchKeyword("%마%");
		System.out.println(search);
		List<Product> list= dao.getProductList(search);
		
//		Map<String, Object> map = dao.getProductList(search);
//		System.out.println(map.get("totalCount"));
//		System.out.println(map.get("productList"));
//		
//		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("::: getCount product :::");
		int count = sqlSession.selectOne("ProductMapper.getCount", search);
//		map.put("totalCount", count);
		System.out.println(count);
//		List<Product> list = sqlSession.selectList("ProductMapper.getProductList", search);
		for(Product pro:list) {
			System.out.println(pro);
		}
//		map.put("productList", list);
	}

}
